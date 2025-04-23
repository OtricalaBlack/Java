package udpserver;

import java.io.IOException;
import java.net.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class UDPServer {
    private static final int SERVER_PORT = 1111;
    private static final int TIMEOUT = 15000; 
    private static final HashMap<String, Long> clients = new HashMap<>();
    private static String integralData = null; 


    private static double aggregatedIntegral = 0.0;
    private static int pendingResults = 0;
  
    private static InetAddress originClientIP = null;
    private static int originClientPort = -1;

    public static void main(String[] args) {
        try (DatagramSocket serverSocket = new DatagramSocket(SERVER_PORT)) {
            System.out.println("UDP Server started on port " + SERVER_PORT);
            byte[] receiveData = new byte[1024];

        
            new Thread(() -> {
                while (true) {
                    try {
                        Thread.sleep(5000); 
                        cleanInactiveClients();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);
                String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
                InetAddress clientIP = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                String clientAddress = clientIP.getHostAddress() + ":" + clientPort;


                clients.put(clientAddress, System.currentTimeMillis());

 
                if (receivedMessage.equals("ping")) {
                    System.out.println("Ping received from " + clientAddress);
                    continue;
                }

                if (receivedMessage.startsWith("IntegralResult:")) {
                    String resultStr = receivedMessage.substring("IntegralResult:".length());
                    try {
                        double partialResult = Double.parseDouble(resultStr);
                        aggregatedIntegral += partialResult;
                        pendingResults--;
                        System.out.println("Received from " + clientAddress + ": " + receivedMessage);
                        System.out.println("Pending results: " + pendingResults);
                    
                        if (pendingResults <= 0) {
                            System.out.println("Total integral result: " + aggregatedIntegral);
                            sendFinalResult(serverSocket, aggregatedIntegral, originClientIP, originClientPort);
                        }
                    } catch (NumberFormatException ex) {
                        System.out.println("Error parsing result from " + clientAddress + ": " + ex.getMessage());
                    }
                    continue;
                }

                System.out.println("Received from " + clientAddress + ": " + receivedMessage);
                System.out.println("Active clients: " + clients.size());

     
                if (receivedMessage.startsWith("IntegralData")) {
                    integralData = receivedMessage;
                    aggregatedIntegral = 0.0;            
                    pendingResults = clients.size();    

         
                    originClientIP = clientIP;
                    originClientPort = clientPort;

                    distributeIntegral(serverSocket);
                }
            }
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }

    private static void cleanInactiveClients() {
        long currentTime = System.currentTimeMillis();
        Iterator<Map.Entry<String, Long>> iterator = clients.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Long> entry = iterator.next();
            if (currentTime - entry.getValue() > TIMEOUT) {
                System.out.println("Client " + entry.getKey() + " disconnected.");
                iterator.remove();
            }
        }
    }

    private static void distributeIntegral(DatagramSocket serverSocket) throws IOException {
        if (integralData == null || clients.isEmpty()) {
            System.out.println("No active clients or integral data.");
            return;
        }
        String[] parts = integralData.split(":")[1].split(",");
        double upperLimit = Double.parseDouble(parts[0]);
        double lowerLimit = Double.parseDouble(parts[1]);
        double step = Double.parseDouble(parts[2]);

        int clientCount = clients.size();
        double rangeSize = (Math.abs(upperLimit - lowerLimit)) / clientCount; 
        int index = 0;

        for (String clientAddress : clients.keySet()) {
            String[] clientInfo = clientAddress.split(":");
            InetAddress clientIP = InetAddress.getByName(clientInfo[0]);
            int clientPort = Integer.parseInt(clientInfo[1]);

            double start = Math.min(lowerLimit, upperLimit) + (index * rangeSize);
            double end = Math.min(start + rangeSize, Math.max(lowerLimit, upperLimit));
            String message = "IntegralSegment:" + start + "," + end + "," + step;

            byte[] sendData = message.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientIP, clientPort);
            serverSocket.send(sendPacket);
            System.out.println("Sent segment to " + clientAddress + ": " + message);
            index++;
        }
    }

    private static void sendFinalResult(DatagramSocket serverSocket, double result, InetAddress clientIP, int clientPort)
            throws IOException {
        if (clientIP == null || clientPort == -1) {
            System.out.println("Origin client not set. Cannot send final result.");
            return;
        }
        String message = "FinalResult:" + result;
        byte[] sendData = message.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientIP, clientPort);
        serverSocket.send(sendPacket);
        System.out.println("Sent final result to " + clientIP.getHostAddress() + ":" + clientPort + ": " + message);
    }
}
