package com.cognixia.jump.main;

public class InvalidEntryException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InvalidEntryException (String c) {
		super("Invalid entry, please enter " + c);
	}


	

}
