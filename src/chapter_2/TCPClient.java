package chapter_2;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPClient {
	public final static String hostname = "100.134.66.106";
	public static void main(String[] args) throws Exception {
		
		String sentence;
		String modifiedSentence;

		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		
		Socket clientSocket = new Socket(hostname, 6666);
		
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
		sentence = inFromUser.readLine();
		
		outToServer.writeBytes(sentence + '\n');
		
		modifiedSentence = inFromServer.readLine();
		
		System.out.println("From Server : " + modifiedSentence);
				
		clientSocket.close();
	}

}
