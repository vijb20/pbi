package com.interbank.cliente.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.interbank.cliente.dto.MessageException;
import com.interbank.cliente.exception.DatabaseException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ControllerExceptionAdvice {
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<MessageException> handlerDatabaseException(DatabaseException exception){
		log.error(exception.getMessageException().getMessage(),exception);
		return new ResponseEntity<>(exception.getMessageException(),exception.getMessageException().getStatus());
	}
	
	@ExceptionHandler(value = {Exception.class,RuntimeException.class})
	public ResponseEntity<MessageException> handlerOtherException(Throwable exception){
		log.error(exception.getMessage(),exception);
		MessageException exceptionMenssage = MessageException.builder()
				.code(103L)
				.message("Error general")
				.build();
		return new ResponseEntity<>(exceptionMenssage,HttpStatus.INTERNAL_SERVER_ERROR);
		}
}
