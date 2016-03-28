package org.priyank.javabrains.messenger.exception;

public class ContentNotFoundException extends RuntimeException{

	/**
	 * Handled Exception
	 */
	private static final long serialVersionUID = -5382574950196874203L;

	public ContentNotFoundException(String message) {
		super(message);
	}
}
