package com.softwareological.obsidian_robot.Protocol;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class OR_Protocol_JUnitTest {

	private OR_Protocol orProtocol = new OR_Protocol();
	private String message = null;
	
	@Test
	void ServerConnection_test() {
		
		if(orProtocol.GetCurrentState() != OR_Protocol.INITIAL_STATE) {
			System.out.println(orProtocol.GetLastReponse());
			fail("Protocol engine should be in INITIAL_STATE");
		}
		
		orProtocol.ProcessMessage(message);
	}
	
	@Test
	void Interacting_test() {
		
		ServerConnection_test();
		message = "Hello Server";
		orProtocol.ProcessMessage(message);
		if(orProtocol.GetCurrentState() != OR_Protocol.INTERACTING_STATE) {
			System.out.println(orProtocol.GetLastReponse());
			fail("Protocol engine should be in INTERACTING_STATE");
		}
		
	}
	
	@Test
	void Termination_test() {
		
		Interacting_test();
		message = "Bye.";
		orProtocol.ProcessMessage(message);
		if(orProtocol.GetCurrentState() != OR_Protocol.FINAL_STATE) {
			System.out.println(orProtocol.GetLastReponse());
			fail("Protocol engine should be in FINAL_STATE");
		}
	}
	
	@Test
	void Closed_test() {
		
		Termination_test();
		message = "Are you closed?";
		orProtocol.ProcessMessage(message);
		if(orProtocol.GetCurrentState() != OR_Protocol.FINAL_STATE) {
			System.out.println(orProtocol.GetLastReponse());
			fail("Protocol engine should be in FINAL_STATE");
		}
	}
	
	
	

}
