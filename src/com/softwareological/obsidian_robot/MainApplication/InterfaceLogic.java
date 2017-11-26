package com.softwareological.obsidian_robot.MainApplication;

import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * Application Interface Logic.
 * This class contains the main application logic that sits behind the GUI interface of
 * OBSIDIAN_ROBOT.
 * @author Kaylen Travis Pillay
 * @version 1.0
 */
public abstract class InterfaceLogic {
	
	/**
	 * Logs the client off the server.
	 * Sends a message to the server, logging the client off the server.
	 * 
	 * @param component The component where the confirmation will be displayed. If null, then the default location will be used.
	 * @author Kaylen Travis Pillay
	 * @return returns true if the client is successfully logged off the server.
	 * @version 1.0
	 */
	public static boolean LogoffClient(Component component) {
		//TODO: Implement the log off method
		
		JOptionPane.showMessageDialog(component, "You have successfully logged off", "Logged off", JOptionPane.INFORMATION_MESSAGE);
		return true;
	}
	
	/**
	 * Displaying help on a particular matter.
	 * This method displays a give help file to the user in a friendly format.
	 * 
	 * @param component The component where the help file will be displayed. If null, then the default location will be used.
	 * @param helpFile This is the path (as a string) to the help file that is to be displayed to the user.
	 * @author Kaylen Travis Pillay
	 * @version 1.0
	 */
	public static void DisplayHelpFile(Component component, String helpFile) {
		
		try(BufferedReader bufferedReader = new BufferedReader(new FileReader(helpFile));){
			
			StringBuilder stringBuilder = new StringBuilder();
			String line;
			while((line = bufferedReader.readLine()) != null) {
				stringBuilder.append(line + "\n");
			}
			
			JOptionPane.showMessageDialog(component, stringBuilder.toString(), "Help", JOptionPane.INFORMATION_MESSAGE);
		}
		catch(IOException e) {
			JOptionPane.showMessageDialog(component, "Error - Cannot open help file: " + helpFile, "Something went wrong!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Connecting to the server.
	 * This method connects the user to the server and returns whether or not this
	 * process was successful.
	 * 
	 * @param component the component where the question will be asked to the user. If null, then the default location will be used.
	 * @return returns true if the user has been successfully connected to the server.
	 * @author Kaylen Travis Pillay
	 * @version 1.0
	 */
	public static boolean ConnectClientToServer(Component component) {
		//TODO : Implement the connection to the server.
		
		JOptionPane.showMessageDialog(component, "Connection Successful - Enjoy chatting!", "Connected", JOptionPane.INFORMATION_MESSAGE);
		return true;
	}
	
	/**
	 * Listing all connected clients.
	 * Generates and displays a list of all clients to the user.
	 * 
	 * @param component the component where the question will be asked to the user. If null, then the default location will be used.
	 * @author Kaylen Travis Pillay
	 * @version 1.0
	 */
	public static void ListClientsConnected(Component component) {
		//TODO: Implement the list clients option. The current code is for testing purposes.
		
		StringBuilder stringBuilder = new StringBuilder("Currently in the chatroom:\n\n");
		stringBuilder.append("\u00BB Kaylen Travis Pillay\n");
		stringBuilder.append("\u00BB Kemira Chetty\n");
		stringBuilder.append("\u00BB Mpilo Maphanga\n");
		stringBuilder.append("\n-- FIN --");
		
		JOptionPane.showMessageDialog(component, stringBuilder.toString(), "People connected to the chatroom.", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * Custom ActionListener for interaction with desktop browser.
	 * NavigateToURL is a custom ActionListener that allow for redirection to the users default 
	 * web browser.
	 * 
	 * @author Kaylen Travis Pillay
	 * @version 1.0
	 */
	public static class NavigateToURL implements ActionListener{

		/**
		 * This is the method that is executed when an action has taken place
		 * on the binded GUI component.
		 * 
		 * @param e ActionEvent parsed through that activates this method.
		 * @author Kaylen Travis Pillay
		 * @version 1.0
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(Desktop.isDesktopSupported()) {
				try {
					Desktop desktop = Desktop.getDesktop();
					desktop.browse(new URI(e.getActionCommand()));
				}
				catch(IOException | URISyntaxException exception) {
					System.out.println("Error: Could not redirect the user to the relevent webpage.");
				}
			}
			
		}
		
	}
	
	/**
	 * Thread class that checks Internet connectivity.
	 * This class allows the ScheduledExecutorService to periodically check the Internet status
	 * of the users device. It then displays to the user.
	 * 
	 * @author Kaylen Travis Pillay
	 * @version 1.0
	 */
	public static class ConnectedToInternetThread implements Runnable{

		private JLabel lblChangeLabel;
		
		/**
		 * Thread Constructor.
		 * This constructor sets the label that is going to output the connectivity result.
		 * 
		 * @param label This is the label that is used to output the status of the connection.
		 * @author Kaylen Travis Pillay
		 * @version 1.0
		 */
		public ConnectedToInternetThread(JLabel label) {
			lblChangeLabel = label;
		}
		
		/**
		 * Thread Run method.
		 * This method executes everything the thread executes. It outputs the connectivity result
		 * to the provided JLabel. Connectivity is checked by attempting to connect to a large
		 * search engine (Google) and returns true if its able too.
		 * 
		 * @author Kaylen Travis Pillay
		 * @version 1.0
		 */
		@Override
		public void run() {
			if(IsConnectedToInternet()) {
				lblChangeLabel.setText("Online");
				lblChangeLabel.setForeground(Color.decode("#228B22"));
			}
			else {
				lblChangeLabel.setText("Offline");
				lblChangeLabel.setForeground(Color.decode("#FF6347"));
			}
		}
		
		private boolean IsConnectedToInternet() {
			
			try(Socket socket = new Socket();){
				String address = "www.google.com";
				InetSocketAddress webCheckAddress = new InetSocketAddress(address, 80);
				socket.connect(webCheckAddress,3000);
				return true;
			}
			catch(IOException e) {
				return false;
			}
		}
		
	}
}
