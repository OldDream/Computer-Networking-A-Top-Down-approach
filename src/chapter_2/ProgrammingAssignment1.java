package chapter_2;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

public class ProgrammingAssignment1 {
	private static final int port = 6666;

	public static void main(String[] args) throws Exception {
		String requestMessageLine;
		String fileName;

		ServerSocket listenSocket = new ServerSocket(port);
		Socket connectionSocket = listenSocket.accept();

		BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
		DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

		requestMessageLine = inFromClient.readLine();
		StringTokenizer tokenizedLine = new StringTokenizer(requestMessageLine);

		if (tokenizedLine.nextToken().equals("GET")) {
			fileName = tokenizedLine.nextToken();
			if (fileName.startsWith("/") == true) {
				fileName = fileName.substring(1);
				File file = new File(fileName);
				int numOfBytes = (int)file.length();
				
				FileInputStream inFile = new FileInputStream(fileName);
				byte[] fileInBytes = new byte[numOfBytes];
				inFile.read(fileInBytes);
				
				outToClient.writeBytes("HTTP/1.0 200 Document Follows \r\n");
				
			}
			else {
				System.out.println("Bad Request Message.");
			}
		}

		/*
		 * while (true) { Socket connectionSocket = welcomeSocket.accept();
		 * BufferedReader inFromClient = new BufferedReader(new
		 * InputStreamReader(connectionSocket.getInputStream()));
		 * 
		 * clientSentence = inFromClient.readLine();
		 * System.out.println(clientSentence + "\n"); }
		 */
	}
}

/*Move to Gt70 test*/
