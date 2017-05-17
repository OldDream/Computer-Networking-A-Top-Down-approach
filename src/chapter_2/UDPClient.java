package chapter_2;

import java.io.*;
import java.net.*;

public class UDPClient {
    private static String hostname = "10.7.28.53";
    private static int port = 6666;

    public static void main(String[] args) throws Exception {

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        DatagramSocket clientSocket = new DatagramSocket();

        InetAddress IPAddress = InetAddress.getByName(hostname);

        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];

        String sentence = inFromUser.readLine();
        sendData = sentence.getBytes();

        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);

        clientSocket.send(sendPacket);
        long startTime = System.currentTimeMillis();

        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

        clientSocket.receive(receivePacket);
        long endTime = System.currentTimeMillis();

        String modifiedSentence = new String(receivePacket.getData());

        System.out.println("From Server : " + modifiedSentence);
        System.out.println("RTT = " + (endTime - startTime) + "ms");

        clientSocket.close();
    }

}
