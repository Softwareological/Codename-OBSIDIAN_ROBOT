package com.softwareological.obsidian_robot.ServerApplication;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

import com.softwareological.obsidian_robot.Protocol.OR_Protocol;

/**
 * Server/Client communication thread.
 * This class helps to implement the multi-client chat feature, by allowing each clients
 * interaction with the server to happen concurrently.
 * 
 * @author Kaylen Travis Pillay
 * @version 1.0
 */
public class ServerCommunicationThread implements Runnable{

	private static Semaphore semaphore = new Semaphore(1,true);
	private static ArrayList<PrintWriter> printWriterCollection = new ArrayList<PrintWriter>();
	private String username;
	private Socket clientsSocket;
	
	public ServerCommunicationThread(Socket socket) {
		clientsSocket = socket;
	}
	
	@Override
	public void run() {
		try(
				Socket client = clientsSocket;
				PrintWriter printWriter = new PrintWriter(client.getOutputStream(), true);
				BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(client.getInputStream()));
		   )
		{
			AddPrintWriter(printWriter);
			OR_Protocol orProtocol = new OR_Protocol();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			username = bufferedReader.readLine();
			RecordEntryInLog("Status: Client Connected - " + username);
			CastToClients(orProtocol.ProcessMessage(null));
			
			String message;
			while((message = bufferedReader.readLine()) != null) {
				if(message.equals("Bye.")) {
					CastToClients("has disconnected from server.");
					RecordEntryInLog("Client: " + username + " has disconnected");
					break;
				}
				else {
					CastToClients(orProtocol.ProcessMessage(message));
				}
			}
		}
		catch(IOException e) {
			RecordEntryInLog("Error Entry: IOException in thread - user: " + username);
		}
	}
	
	protected static void RecordEntryInLog(String logEntry) {
		
		try (PrintWriter printWriter = new PrintWriter(new FileWriter("Log Files/server_log",true))){
			semaphore.acquire();
			printWriter.println(logEntry);
			semaphore.release();
		}
		catch(IOException e) {
			System.out.println("Error: Unable to write to log file.");
		}
		catch(InterruptedException e1) {
			System.out.println("Error: Semaphore Interrupted while writing to log file.");
		}
		
	}
	
	private void CastToClients(String message) {
		
		try {
			semaphore.acquire();
			for(PrintWriter out: printWriterCollection) {
				out.println(username + " \u00BB " + message);
			}
			semaphore.release();
		}
		catch(InterruptedException e) {
			RecordEntryInLog("Error: Semaphore interrupted!");
		}
		
	}
	
	private void AddPrintWriter(PrintWriter printWriter) {
		
		try {
			semaphore.acquire();
			printWriterCollection.add(printWriter);
			semaphore.release();
		}
		catch(InterruptedException e) {
			RecordEntryInLog("Error: Semaphore interrupted!");
		}
	}

}
