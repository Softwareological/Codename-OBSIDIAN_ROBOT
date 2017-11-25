package com.softwareological.obsidian_robot.MainApplication;

import java.awt.EventQueue;

import javax.swing.JFrame;

/**
 * Main Application (Client).
 * This class represents the main client application, which will be the top layer of
 * OBSIDIAN_ROBOT. This will be the only means by which a user will interact with the
 * software.
 * 
 * @author Kaylen Travis Pillay
 * @version 1.0
 */
public class OBSIDIAN_ROBOT {

	private JFrame contentFrame;

	/**
	 * Launch the application.
	 * The main method here launches the application window, the GUI interface,
	 * that the user of the software can interact with.
	 * @param args (Not Used) Command-line arguments are not used!
	 * @author Kaylen Travis Pillay
	 * @version 1.0
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OBSIDIAN_ROBOT window = new OBSIDIAN_ROBOT();
					window.contentFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructor.
	 * Creates the application window and starts up the GUI.
	 * 
	 * @author Kaylen Travis Pillay
	 * @version 1.0
	 */
	public OBSIDIAN_ROBOT() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @author Kaylen Travis Pillay
	 * @version 1.0
	 */
	private void initialize() {
		contentFrame = new JFrame();
		contentFrame.setBounds(100, 100, 450, 300);
		contentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
