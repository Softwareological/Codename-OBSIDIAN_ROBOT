package com.softwareological.obsidian_robot.Protocol;

/**
 * This protocol engine used for communication between clients and the server.
 * @author Kaylen Travis Pillay
 * @version 1.0
 */
public class OR_Protocol {

	private static final int INITIAL_STATE = 1;
	private static final int INTERACTING_STATE = 2;
	private static final int FINAL_STATE = 3;
	
	private String response;
	private int currentState;
	
	/**
	 * Constructor.
	 * No argument constructor for the protocol, sets the
	 * current state to INITIAL_STATE.
	 * 
	 * @author Kaylen Travis Pillay
	 * @version 1.0
	 */
	public OR_Protocol() {
		currentState = INITIAL_STATE;
		response = "NONE";
	}
	
	/**
	 * Returns the processed response string from the parsed message.
	 * 
	 * @param message (Required) Message that needs to be processed by the protocol engine.
	 * @return Response message that can be interpreted by the server.
	 * @author Kaylen Travis Pillay
	 * @version 1.0
	 */
	public String ProcessMessage(String message) {
		
		if (currentState == INITIAL_STATE) {
			response = "Connected to server";
			currentState = INTERACTING_STATE;
		}
		else if(currentState == INTERACTING_STATE){
			if(message.equals("Bye.")) {
				response = "Disconnected from server";
				currentState = FINAL_STATE;
			}else {
				response = message;
				currentState = INTERACTING_STATE;
			}
		}
		else {
			response = "Client is disconnected from server";
		}
		
		return response;
		
	}
	
	/**
	 * Returns the last reponse from engine
	 * 
	 * @return The last reponse that was sent from the protocol engine
	 * @version 1.0
	 * @author Kaylen Travis Pillay
	 */
	public String LastReponse() {
		return response;
	}
}
