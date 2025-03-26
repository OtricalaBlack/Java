package javaapplication3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;

public class ServerConnect {
    private static final String SERVER_ADDRESS = "localhost"; 
    private static final int SERVER_PORT = 1111;               
    private static final int RECONNECT_DELAY = 3000;           

    private static PrintWriter out; 
    private final List<RecIntegral> receivedIntegrals = new LinkedList<>();  
    private final Queue<Socket> clientSockets = new ConcurrentLinkedQueue<>(); 


    private static double finalSum = 0.0;


    public static double getFinalSum() {
        return finalSum;
    }

    public static synchronized void setOutputWriter(PrintWriter writer) {
        out = writer;
    }

    public static synchronized PrintWriter getOutputWriter() {
        return out;
    }

    public void start() {
        while (true) {
            try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {

                System.out.println("Connected to server " + SERVER_ADDRESS + ":" + SERVER_PORT);
                setOutputWriter(writer);
                clientSockets.add(socket); 
                Thread readerThread = new Thread(() -> {
                    try {
                        String serverMessage;
                        while ((serverMessage = in.readLine()) != null) {
                            System.out.println("Received from server: " + serverMessage);
                            
                            if (serverMessage.startsWith("finalsum:")) {
                                try {
                                    String resultStr = serverMessage.substring("finalsum:".length()).trim();
                                    finalSum = Double.parseDouble(resultStr.replace(",", "."));
                                    System.out.println("Final result stored in ServerConnect: " + finalSum);
                                } catch (Exception ex) {
                                    System.out.println("Error parsing final result: " + serverMessage + " - " + ex.getMessage());
                                }
                            }
                            else if (serverMessage.startsWith("Task for client:")) {
                                processTask(serverMessage, writer); 
                            } else {
                                processReceivedMessage(serverMessage);
                            }
                        }
                    } catch (IOException e) {
                        System.out.println("Lost connection to server");
                    }
                });
                readerThread.start();

                // Keep the connection alive
                Thread.sleep(Long.MAX_VALUE);

            } catch (IOException | InterruptedException e) {
                System.out.println("Error connecting to server, retrying in 3 seconds...");
                try {
                    Thread.sleep(RECONNECT_DELAY);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    System.out.println("Thread interrupted");
                    return;
                }
            }
        }
    }

    // Метод для обработки полученных сообщений от сервера и разбора их на объект RecIntegral
    private void processReceivedMessage(String message) {

        if (message.startsWith("finalsum:")) {
            return;
        }
        try {
            String[] parts = message.split(";");
            if (parts.length < 3) {
                System.out.println("Incomplete message: " + message);
                return;
            }

            double lower = Double.parseDouble(parts[0].split(":")[1].trim());
            double upper = Double.parseDouble(parts[1].split(":")[1].trim());
            double step = Double.parseDouble(parts[2].split(":")[1].trim());

            RecIntegral integral = new RecIntegral(lower, upper, step);
            synchronized (receivedIntegrals) {
                receivedIntegrals.add(integral);
            }
            System.out.println("Parsed and added to list: " + integral);
        } catch (Exception e) {
            System.out.println("Error parsing message: " + message + " - " + e.getMessage());
        }
    }

    private double integrateTrapezoidal(double a, double b, double h) {
        double sum = 0.0;

        for (double x = a; x < b; x += h) {
            sum += 0.5 * (Math.tan(x) + Math.tan(x + h)) * h;
        }
        return sum;
    }

    // Многопоточный метод для вычисления интеграла, с использованием не более 4 потоков
    private double integrateMultiThread(double a, double b, double h) throws InterruptedException {
        int steps = (int) Math.ceil((b - a) / h);
        int maxThreads = 4;

        int numThreads = Math.min(maxThreads, steps);
        if (numThreads < 1) {
            numThreads = 1;
        }

        double intervalLength = b - a;
        double subIntervalLength = intervalLength / numThreads;


        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        final double[] partialResults = new double[numThreads];
        List<Future<?>> futures = new LinkedList<>();

        for (int i = 0; i < numThreads; i++) {
            final int idx = i;
            final double subA = a + i * subIntervalLength;
            // Для последнего потока гарантируем покрытие до b
            final double subB = (i == numThreads - 1) ? b : subA + subIntervalLength;
            Future<?> future = executor.submit(() -> {
                partialResults[idx] = integrateTrapezoidal(subA, subB, h);
            });
            futures.add(future);
        }


        for (Future<?> f : futures) {
            try {
                f.get();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();

        // Суммируем результаты
        double total = 0.0;
        for (double pr : partialResults) {
            total += pr;
        }
        return total;
    }


    private void processTask(String taskMessage, PrintWriter writer) {
        try {
            // Заменяем запятые на точки для корректного разбора чисел
            taskMessage = taskMessage.replace(",", ".");

            // Ожидаемый формат сообщения:
            // "Task for client: lower: 1.000000; upper: 4.000000; step: 1.000000;"
            int index = taskMessage.indexOf("lower:");
            if (index == -1) {
                throw new IllegalArgumentException("Invalid task format: " + taskMessage);
            }
            String paramsPart = taskMessage.substring(index);
            String[] parts = paramsPart.split(";");
            if (parts.length < 3) {
                throw new IllegalArgumentException("Invalid task format: " + taskMessage);
            }

            double lower = Double.parseDouble(parts[0].split(":")[1].trim());
            double upper = Double.parseDouble(parts[1].split(":")[1].trim());
            double step = Double.parseDouble(parts[2].split(":")[1].trim());

            System.out.printf("Processing task: lower=%.6f, upper=%.6f, step=%.6f%n", lower, upper, step);

            double result = integrateMultiThread(lower, upper, step);


            writer.println(String.format("sum: %.6f", result));
            System.out.println("Result sent to server: sum: " + result);

        } catch (Exception e) {
            System.out.println("Error processing task: " + taskMessage + " - " + e.getMessage());
        }
    }
}
