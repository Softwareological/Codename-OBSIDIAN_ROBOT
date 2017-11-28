package com.softwareological.obsidian_robot.ServerApplication;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Main Server Application.
 * The main server application facilitates the chat between multiple clients.
 * 
 * @author Kaylen Travis Pillay
 * @version 1.0
 */
public class OBSIDIAN_ROBOT_Server {

	public static void main(String[] args) {

		int portNumber = 4444;

		try(ServerSocket serverSocket = new ServerSocket(portNumber);)
		{
			ServerCommunicationThread.RecordEntryInLog("\n==================\nNew Server Session\n==================\n");
			while(true) {
				Thread thread = new Thread(new ServerCommunicationThread(serverSocket.accept()));
				thread.start();
			}
			
		}
		catch(IOException e) {
			ServerCommunicationThread.RecordEntryInLog("Error entry: Cannot open serversocket on port number - " + portNumber);
		}
	}

}
