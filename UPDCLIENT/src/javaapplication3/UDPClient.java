package javaapplication3;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class UDPClient {
    private DatagramSocket clientSocket;
    private InetAddress serverAddress;
    private final int SERVER_PORT = 1111; 
    private boolean connected = false;
    

    public volatile double finalResult = 0.0;

    public UDPClient() {
        try {
            serverAddress = InetAddress.getByName("127.0.0.1"); 
            clientSocket = new DatagramSocket(); 
            connected = true;
            System.out.println("UDP client initialized on port: " + clientSocket.getLocalPort());
        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }

    public void sendPing() {
        if (!connected) {
            System.out.println("Client is not connected.");
            return;
        }
        new Thread(() -> {
            while (connected) {
                try {
                    String message = "ping";
                    byte[] sendData = message.getBytes();
                    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, SERVER_PORT);
                    clientSocket.send(sendPacket);
                    System.out.println("Ping sent to the server from port " + clientSocket.getLocalPort());
                    Thread.sleep(4000); 
                } catch (IOException | InterruptedException e) {
                    System.out.println("Error sending ping: " + e.getMessage());
                    connected = false;
                }
            }
        }).start();
    }

    public void sendMessage(String message) {
        if (!connected) {
            System.out.println("Client is not connected.");
            return;
        }
        new Thread(() -> {
            try {
                byte[] sendData = message.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, SERVER_PORT);
                clientSocket.send(sendPacket);
                System.out.println("Message sent: " + message);
            } catch (IOException e) {
                System.out.println("Error sending message: " + e.getMessage());
            }
        }).start();
    }

    public void startListening() {
        new Thread(() -> {
            try {
                System.out.println("Client listening on port: " + clientSocket.getLocalPort());
                byte[] receiveData = new byte[1024];

                while (connected) {
                    DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                    clientSocket.receive(receivePacket);
                    String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
                    System.out.println("Received from server: " + receivedMessage);

                    if (receivedMessage.startsWith("FinalResult:")) {
                        String resStr = receivedMessage.substring("FinalResult:".length());
                        try {
                            finalResult = Double.parseDouble(resStr);
                            System.out.println("Final result updated: " + finalResult);
                        } catch (NumberFormatException ex) {
                            System.out.println("Error parsing final result: " + ex.getMessage());
                        }
                        continue;
                    }


                    if (receivedMessage.startsWith("IntegralSegment:")) {

                        String data = receivedMessage.substring("IntegralSegment:".length());
                        String[] parts = data.split(",");
                        if (parts.length >= 3) {
                            try {
                                double segStart = Double.parseDouble(parts[0]);
                                double segEnd = Double.parseDouble(parts[1]);
                                double segStep = Double.parseDouble(parts[2]);

                                double result = multiThreadComputeIntegral(segStart, segEnd, segStep);
                                String resultMessage = "IntegralResult:" + result;
                                sendMessage(resultMessage);
                                System.out.println("Computed integral: " + result + " for segment [" + segStart + ", " + segEnd + "]");
                            } catch (NumberFormatException ex) {
                                System.out.println("Error parsing segment data: " + ex.getMessage());
                            }
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println("Error receiving data: " + e.getMessage());
            }
        }).start();
    }


    private double multiThreadComputeIntegral(double segStart, double segEnd, double step) {
 
        int actualParts = (int) ((segEnd - segStart) / step);

        int threadCount = Math.min(4, Math.max(1, actualParts));
        double range = (segEnd - segStart) / threadCount;

        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        List<Future<Double>> futures = new ArrayList<>();

        for (int i = 0; i < threadCount; i++) {
            final double partStart = segStart + i * range;
            final double partEnd = (i == threadCount - 1) ? segEnd : partStart + range;
            Callable<Double> task = () -> {
                double partialSum = 0.0;
                for (double x = partStart; x < partEnd; x += step) {
                    partialSum += 0.5 * (f(x) + f(x + step)) * step;
                }
                return partialSum;
            };
            futures.add(executor.submit(task));
        }

        double sum = 0.0;
        for (Future<Double> f : futures) {
            try {
                sum += f.get();
            } catch (InterruptedException | ExecutionException e) {
                System.out.println("Error in thread: " + e.getMessage());
            }
        }
        executor.shutdown();
        return sum;
    }

    private double f(double x) {
        return Math.tan(x);
    }

    public void closeClient() {
        if (clientSocket != null && !clientSocket.isClosed()) {
            clientSocket.close();
            connected = false;
            System.out.println("UDP client disconnected.");
        }
    }
}
