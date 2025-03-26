package multithreadedserver;

import java.io.*;
import java.net.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Server {
    private static final int PORT = 1111;

    private static final List<Socket> connectedClients = Collections.synchronizedList(new LinkedList<>());

    private static volatile int expectedTaskCount = 0;             
    private static volatile PrintWriter currentRequestorOut = null;  
    private static final List<Double> aggregatedSums = Collections.synchronizedList(new LinkedList<>());

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server running on port: " + PORT);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New connection from " + clientSocket.getInetAddress());
                connectedClients.add(clientSocket);
                System.out.println("Total connected clients: " + connectedClients.size());
                new Thread(() -> handleClient(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket clientSocket) {
        try (
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
        ) {
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                try {
                    if (message.startsWith("sum:")) {
                        message = message.replace(",", "."); 
                        double sum = Double.parseDouble(message.split(":")[1].trim());
                        synchronized (Server.class) {
                            aggregatedSums.add(sum);
                            System.out.printf("Received sum: %.6f from client%n", sum);
                            if (aggregatedSums.size() == expectedTaskCount && currentRequestorOut != null) {
                                double totalSum = aggregatedSums.stream().mapToDouble(Double::doubleValue).sum();
                                currentRequestorOut.println(String.format("finalsum: %.6f", totalSum));
                                System.out.println("Final sum sent to requesting client: " + totalSum);
                                aggregatedSums.clear();
                                expectedTaskCount = 0;
                                currentRequestorOut = null;
                            }
                        }
                    } else {

                        message = message.replace(",", "."); 
                        String[] parts = message.split(";");
                        double lower = Double.parseDouble(parts[0].split(":")[1].trim());
                        double upper = Double.parseDouble(parts[1].split(":")[1].trim());
                        double step = Double.parseDouble(parts[2].split(":")[1].trim());
                        System.out.printf("Parsed integral parameters: lower=%.6f, upper=%.6f, step=%.6f%n", lower, upper, step);

                        int partsCount = calculatePartsCount(lower, upper, step);
                        System.out.printf("The integral will have %d parts.%n", partsCount);

                
                        synchronized (Server.class) {
                            currentRequestorOut = out;
                            aggregatedSums.clear();
                            expectedTaskCount = connectedClients.size();
                        }

                        distributeTasks(lower, upper, step, partsCount);

                        out.println("Integral processed successfully. Parts count: " + partsCount);
                    }
                } catch (Exception e) {
                    out.println("Error: " + e.getMessage());
                    System.out.println("Error processing input: " + message + " - " + e.getMessage());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                synchronized (connectedClients) {
                    connectedClients.remove(clientSocket);
                }
                clientSocket.close();
                System.out.println("Client disconnected");
                System.out.println("Total connected clients: " + connectedClients.size());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Метод для подсчёта количества частей интеграла
    private static int calculatePartsCount(double lower, double upper, double step) {
        return (int) Math.ceil((upper - lower) / step);
    }

    // Метод для распределения заданий между клиентами
    private static void distributeTasks(double lower, double upper, double step, int totalParts) {
        synchronized (connectedClients) {
            if (connectedClients.isEmpty()) {
                System.out.println("No connected clients to distribute tasks.");
                return;
            }
            int clientsCount = connectedClients.size();
            int partsPerClient = totalParts / clientsCount;
            int remainingParts = totalParts % clientsCount;
            System.out.printf("Distributing %d parts among %d clients.%n", totalParts, clientsCount);
            
            double currentLower = lower;
            for (int i = 0; i < clientsCount; i++) {
                double clientUpper = currentLower + partsPerClient * step;
                if (i == clientsCount - 1) {

                    clientUpper += remainingParts * step;
                }

                String taskMessage = String.format("Task for client: lower: %.6f; upper: %.6f; step: %.6f;", 
                        currentLower, clientUpper, step);
                try {
                    Socket client = connectedClients.get(i);
                    PrintWriter clientOut = new PrintWriter(client.getOutputStream(), true);
                    clientOut.println(taskMessage);
                    System.out.println("Sent to client: " + taskMessage);
                } catch (IOException e) {
                    System.out.println("Error sending task to client: " + e.getMessage());
                }
                currentLower = clientUpper;
            }
        }
    }
}
