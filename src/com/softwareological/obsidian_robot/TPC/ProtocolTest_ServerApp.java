package com.softwareological.obsidian_robot.TPC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import com.softwareological.obsidian_robot.Protocol.OR_Protocol;

/**
 * Protocol Test Sever console test application.
 * 
 * This Protocol Test Server is the server component to the test application
 * that provides a practical test of the protocol used in this
 * project.
 * 
 * @author Kaylen Travis Pillay
 * @version 1.0
 *
 */
public class ProtocolTest_ServerApp {

	/**
	 * Application.
	 * 
	 * Server console test application.
	 * Runs the Protocol Test server that tests the OR_Protocol.
	 * 
	 * @param args command-line arguments required for this server
	 * @author Kaylen Travis Pillay
	 * @version 1.0
	 */
	public static void main(String[] args) {
		
		int portNumber = 4444;
		
		try(
			ServerSocket serverSocket = new ServerSocket(portNumber);
			Socket clientSocket = serverSocket.accept();
			PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			)
		{
			System.out.println("Server Running");
			OR_Protocol orProtocol = new OR_Protocol();
			printWriter.println(orProtocol.ProcessMessage(null));
			
			String message;
			while((message = bufferedReader.readLine()) != null) {
				printWriter.println("Server: " + orProtocol.ProcessMessage(message));
				if(message.equals("Bye.")) {
					System.out.println("Server shut down.");
					break;
				}
			}
		}
		catch(IOException e) {
			System.out.println("Unable to start server on port " + portNumber);
		}
	}

}
