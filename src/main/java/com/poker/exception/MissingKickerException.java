package com.poker.exception;

public class MissingKickerException extends RuntimeException {

	private static final String WHERE_IS_KICKER_AT_MESSAGE = "Where is kicker at???";
	private static final long serialVersionUID = 1L;

	public MissingKickerException() {
		super(WHERE_IS_KICKER_AT_MESSAGE);
	}


	
}
