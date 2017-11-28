package com.softwareological.obsidian_robot.MainApplication;

import java.awt.EventQueue;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JSplitPane;

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

	protected JFrame contentFrame;
	private static final String GITHUB_PAGES = "https://softwareological.github.io/Codename-OBSIDIAN_ROBOT/";
	private static final String GITHUB_PROJECT_PAGE = "https://github.com/Softwareological/Codename-OBSIDIAN_ROBOT";
	private static final String PROJECT_CONTRIBUTORS = "https://github.com/Softwareological/Codename-OBSIDIAN_ROBOT/graphs/contributors";

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
		ActionListener navigateToURL = new InterfaceLogic.NavigateToURL();
		
		
		contentFrame = new JFrame();
		contentFrame.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentFrame.setResizable(false);
		contentFrame.setBackground(Color.LIGHT_GRAY);
		contentFrame.setTitle("OBSIDIAN_ROBOT - By Softwareological");
		contentFrame.setBounds(100, 100, 863, 563);
		contentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel statusPanel = new JPanel();
		statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
		contentFrame.getContentPane().add(statusPanel, BorderLayout.SOUTH);
		statusPanel.setPreferredSize(new Dimension(contentFrame.getWidth(), 20));
		statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));
		JLabel statusLabel = new JLabel("Server Status: ");
		statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
		statusPanel.add(statusLabel);
		
		JLabel lblServerStatus = new JLabel("Not Connected");
		lblServerStatus.setForeground(Color.decode("#FF6347"));
		lblServerStatus.setHorizontalAlignment(SwingConstants.RIGHT);
		lblServerStatus.setFont(new Font("Tahoma", Font.BOLD, 11));
		statusPanel.add(lblServerStatus);
		
		JSeparator separator_1 = new JSeparator();
		statusPanel.add(separator_1);
		
		JLabel internetStatus = new JLabel("Internet Status: ");
		internetStatus.setHorizontalAlignment(SwingConstants.RIGHT);
		statusPanel.add(internetStatus);
		
		JLabel lblInternetStatus = new JLabel("Status Pending");
		lblInternetStatus.setFont(new Font("Tahoma", Font.BOLD, 11));
		statusPanel.add(lblInternetStatus);
		
		Thread internetCheckThread = new Thread(new InterfaceLogic.ConnectedToInternetThread(lblInternetStatus));
		
		JPanel chatPanel = new JPanel();
		contentFrame.getContentPane().add(chatPanel, BorderLayout.CENTER);
		chatPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblObsidianrobot = new JLabel("OBSIDIAN_ROBOT");
		lblObsidianrobot.setFont(new Font("Source Sans Pro", Font.BOLD | Font.ITALIC, 20));
		lblObsidianrobot.setHorizontalAlignment(SwingConstants.CENTER);
		chatPanel.add(lblObsidianrobot, BorderLayout.NORTH);
		
		JPanel messageConstructionPanel = new JPanel();
		chatPanel.add(messageConstructionPanel, BorderLayout.SOUTH);
		
		JLabel lblMessage = new JLabel("Message: ");
		messageConstructionPanel.add(lblMessage);
		
		JScrollPane messageScrollPane = new JScrollPane();
		messageConstructionPanel.add(messageScrollPane);
		
		JTextArea txtAreaMessage = new JTextArea();
		txtAreaMessage.setEnabled(false);
		txtAreaMessage.setRows(3);
		txtAreaMessage.setLineWrap(true);
		txtAreaMessage.setColumns(40);
		messageScrollPane.setViewportView(txtAreaMessage);
		
		JPanel messageViewPanel = new JPanel();
		chatPanel.add(messageViewPanel, BorderLayout.CENTER);
		messageViewPanel.setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		messageViewPanel.add(splitPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		splitPane.setRightComponent(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		JPanel chatMessagePanel = new JPanel();
		scrollPane.setViewportView(chatMessagePanel);
		chatMessagePanel.setLayout(new BoxLayout(chatMessagePanel, BoxLayout.PAGE_AXIS));
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setLeftComponent(splitPane_1);
		
		JPanel panel_1 = new JPanel();
		splitPane_1.setLeftComponent(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblCurrentlyChattingAs = new JLabel("Currently chatting as: ");
		lblCurrentlyChattingAs.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblCurrentlyChattingAs, BorderLayout.WEST);
		
		JLabel lblUsername = new JLabel("Not connected");
		panel_1.add(lblUsername, BorderLayout.CENTER);
		
		JLabel lblDetails = new JLabel("Details:");
		panel_1.add(lblDetails, BorderLayout.NORTH);
		lblDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblDetails.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lblNewLabel = new JLabel("   ");
		panel_1.add(lblNewLabel, BorderLayout.EAST);
		
		JPanel panel_2 = new JPanel();
		splitPane_1.setRightComponent(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_2.add(scrollPane_1, BorderLayout.CENTER);
		
		JLabel lblServerDetails = new JLabel("Server Details:");
		lblServerDetails.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblServerDetails.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane_1.setColumnHeaderView(lblServerDetails);
		
		JPanel panel_3 = new JPanel();
		scrollPane_1.setViewportView(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JTextArea txtrFeatureComingSoon = new JTextArea();
		txtrFeatureComingSoon.setWrapStyleWord(true);
		txtrFeatureComingSoon.setLineWrap(true);
		txtrFeatureComingSoon.setText("\r\n\r\nFeature coming soon!  V1.1 includes this feature and many others. To find out more, check out this projects GitHub Page ( Help -> Developers -> GitHub Page ).\r\n\r\nPlease take the time to rate this chat application. Your feedback helps the developers grow and produce better software, thank you.\r\n\r\nSend you feedback to softwareological@outlook.com");
		txtrFeatureComingSoon.setEditable(false);
		panel_3.add(txtrFeatureComingSoon, BorderLayout.CENTER);

		long checkPeriod = 5;
		ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
		scheduledExecutorService.scheduleAtFixedRate(internetCheckThread, 0, checkPeriod, TimeUnit.SECONDS);
		
		JMenuBar menuBar = new JMenuBar();
		contentFrame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setMnemonic(KeyEvent.VK_ALT);
		menuBar.add(mnFile);
		
		JMenuItem mntmListPeopleIn = new JMenuItem("List People In Chat");
		mntmListPeopleIn.setToolTipText("Get the list of people connected to the chat");
		mntmListPeopleIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceLogic.ListClientsConnected(contentFrame);
			}
		});
		mntmListPeopleIn.setVisible(false);
		
		
		JSeparator separator = new JSeparator();
		separator.setVisible(false);
		
		
		JMenuItem mntmExitChatRoom = new JMenuItem("Exit Chat Room");
		
		mntmExitChatRoom.setToolTipText("Leave to chatroom and log off the server");
		mntmExitChatRoom.setVisible(false);
		
		
		JMenuItem mntmConnectToServer = new JMenuItem("Connect To Server");
		mntmConnectToServer.setToolTipText("Connect to the chatroom");
		
		mnFile.add(mntmConnectToServer);
		mnFile.add(mntmListPeopleIn);
		mnFile.add(separator);
		mnFile.add(mntmExitChatRoom);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenu mnUsage = new JMenu("Usage");
		mnUsage.setToolTipText("Get help with using OBSIDIAN_ROBOT");
		mnHelp.add(mnUsage);
		
		JMenuItem mntmConnectingWithServer = new JMenuItem("Connecting with server");
		mntmConnectingWithServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceLogic.DisplayHelpFile(contentFrame, "Help Files/CONNECTING_TO_SERVER");
			}
		});
		mnUsage.add(mntmConnectingWithServer);
		
		JMenuItem mntmSendingAMessage = new JMenuItem("Sending a message");
		mntmSendingAMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceLogic.DisplayHelpFile(contentFrame, "Help Files/SENDING_A_MESSAGE");
			}
		});
		mnUsage.add(mntmSendingAMessage);
		
		JMenuItem mntmLeavingTheChat = new JMenuItem("Leaving the chat room");
		mntmLeavingTheChat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceLogic.DisplayHelpFile(contentFrame, "Help Files/LEAVING_CHAT");
			}
		});
		mnUsage.add(mntmLeavingTheChat);
		
		JMenu mnDevelopers = new JMenu("Developers");
		mnDevelopers.setToolTipText("Some stuff for developer!");
		mnHelp.add(mnDevelopers);
		
		JMenuItem mntmProjectContributors = new JMenuItem("Project Contributors");
		mntmProjectContributors.setActionCommand(PROJECT_CONTRIBUTORS);
		mntmProjectContributors.addActionListener(navigateToURL);
		mnDevelopers.add(mntmProjectContributors);
		
		JMenuItem mntmGithubPage = new JMenuItem("GitHub Page");
		mntmGithubPage.setActionCommand(GITHUB_PAGES);
		mntmGithubPage.addActionListener(navigateToURL);
		mnDevelopers.add(mntmGithubPage);
		
		JSeparator separator_3 = new JSeparator();
		mnDevelopers.add(separator_3);
		
		JMenuItem mntmForkMeOn = new JMenuItem("Fork Me On GitHub");
		mntmForkMeOn.setActionCommand(GITHUB_PROJECT_PAGE);
		mntmForkMeOn.addActionListener(navigateToURL);
		mnDevelopers.add(mntmForkMeOn);
		
		JSeparator separator_2 = new JSeparator();
		mnHelp.add(separator_2);
		
		JMenuItem mntmLicence = new JMenuItem("Licence");
		mntmLicence.setToolTipText("Read the license for OBSIDIAN_ROBOT");
		mntmLicence.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceLogic.DisplayHelpFile(contentFrame, "LICENSE");
			}
		});
		mnHelp.add(mntmLicence);
		
		JMenuItem mntmAboutSoftwareological = new JMenuItem("About Softwareological");
		mntmAboutSoftwareological.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceLogic.DisplayHelpFile(contentFrame, "ABOUT_SOFTWAREOLOGICAL");
			}
		});
		mntmAboutSoftwareological.setToolTipText("Information about the Open-Source organization, Softwareological");
		mnHelp.add(mntmAboutSoftwareological);
		
		JButton btnSend = new JButton("Send");
		btnSend.setEnabled(false);
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceLogic.SendMessage(contentFrame, txtAreaMessage.getText());
				txtAreaMessage.setText("");
			}
		});
		btnSend.setBackground(new Color(51, 255, 0));
		messageConstructionPanel.add(btnSend);
		
		mntmConnectToServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(InterfaceLogic.ConnectClientToServer(contentFrame)) {
				
					lblServerStatus.setText("Connected");
					lblServerStatus.setForeground(Color.decode("#228B22"));
					mntmListPeopleIn.setVisible(true);
					mntmExitChatRoom.setVisible(true);
					separator.setVisible(true);
					mntmConnectToServer.setEnabled(false);
					mntmConnectToServer.setToolTipText("You are already connected to the chatroom!");
					
					btnSend.setEnabled(true);
					txtAreaMessage.setEnabled(true);
					lblUsername.setText(InterfaceLogic.username);
					
					Thread thread = new Thread(new InterfaceLogic.MessageReaderThread(chatMessagePanel, contentFrame));
					thread.start();
				}
			}
		});
		
		mntmExitChatRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(InterfaceLogic.LogoffClient(contentFrame)) {
					lblServerStatus.setText("Not Connected");
					lblServerStatus.setForeground(Color.decode("#FF6347"));
					mntmListPeopleIn.setVisible(false);
					mntmExitChatRoom.setVisible(false);
					separator.setVisible(false);
					mntmConnectToServer.setEnabled(true);
					mntmConnectToServer.setToolTipText("Connect to the server to start chatting");
					
					btnSend.setEnabled(false);
					txtAreaMessage.setEnabled(false);
					lblUsername.setText("Not Connected");
				}
			}
		});
	}
}
