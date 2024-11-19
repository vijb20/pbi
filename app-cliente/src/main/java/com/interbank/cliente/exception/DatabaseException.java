package com.interbank.cliente.exception;

import com.interbank.cliente.dto.MessageException;

public class DatabaseException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final MessageException messageException;
	
	public DatabaseException(MessageException messageException) {
		super();
		this.messageException = messageException;
	}

	public DatabaseException(MessageException messageException, Throwable cause) {
		super( cause);
		this.messageException = messageException;
	}

	public MessageException getMessageException() {
		return messageException;
	}
	
}
