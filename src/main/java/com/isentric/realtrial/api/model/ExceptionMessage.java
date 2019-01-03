package com.isentric.realtrial.api.model;

public class ExceptionMessage 
{
	private String userMessage;
	private String devMessage;
	
	public ExceptionMessage() {}
	
	public ExceptionMessage(String userMessage, String devMessage) 
	{
		super();
		this.userMessage = userMessage;
		this.devMessage = devMessage;
	}
	
	public String getUserMessage() 
	{
		return userMessage;
	}
	public void setUserMessage(String userMessage) 
	{
		this.userMessage = userMessage;
	}
	
	public String getDevMessage() 
	{
		return devMessage;
	}
	public void setDevMessage(String devMessage) 
	{
		this.devMessage = devMessage;
	}
}
