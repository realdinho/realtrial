package com.isentric.realtrial.api.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.isentric.realtrial.api.model.ExceptionMessage;

@ControllerAdvice
public class RealTrialExceptionHandler extends ResponseEntityExceptionHandler
{
	@Autowired
	MessageSource messageSource;
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) 
	{
		String userMsg = messageSource.getMessage("messages.badrequest", null, LocaleContextHolder.getLocale());
		String devMsg = ex.getCause() != null ? ex.getCause().toString() : ex.toString();
		
		ExceptionMessage message = new ExceptionMessage(userMsg, devMsg);
		
		return handleExceptionInternal(ex, message, headers, HttpStatus.BAD_REQUEST, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) 
	{
		List<ExceptionMessage> exceptionMessages = createExceptionMessageList(ex.getBindingResult());
		
		return handleExceptionInternal(ex, exceptionMessages, headers, HttpStatus.BAD_REQUEST, request);
	}
	
	private List<ExceptionMessage> createExceptionMessageList(BindingResult bindingResult)
	{
		List<ExceptionMessage> exceptionMessages = new ArrayList<>();
		
		for(FieldError fe : bindingResult.getFieldErrors())
		{
			String userMsg = messageSource.getMessage(fe, LocaleContextHolder.getLocale());
			String devMsg = fe.toString();
			
			exceptionMessages.add(new ExceptionMessage(userMsg, devMsg));
		}
		
		return exceptionMessages;
	}
	
	@ExceptionHandler({ EmptyResultDataAccessException.class })
	public ResponseEntity<Object> handleEmptyResultDataAcessExceptionHandler(EmptyResultDataAccessException ex, 
		WebRequest request)
	{
		String userMsg = messageSource.getMessage("resource.notfound", null, LocaleContextHolder.getLocale());
		String devMsg = ex.getCause() != null ? ex.getCause().toString() : ex.toString();
		
		ExceptionMessage exceptionMessages = new ExceptionMessage(userMsg, devMsg);
		
		return handleExceptionInternal(ex, exceptionMessages, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
}
