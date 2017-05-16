package chapter_2;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class P12 {
	private static final int port = 6666;

	public static void main(String[] args) throws Exception {
		String clientSentence;
		ServerSocket welcomeSocket = new ServerSocket(port);

		while (true) {
			Socket connectionSocket = welcomeSocket.accept();
			
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			
			clientSentence = inFromClient.readLine();
			System.out.println(clientSentence + "\n");
		}
	}
}
