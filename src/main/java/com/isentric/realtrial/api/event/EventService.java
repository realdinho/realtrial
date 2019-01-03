package com.isentric.realtrial.api.event;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationEvent;

public class EventService extends ApplicationEvent
{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private HttpServletResponse response;
	
	public EventService(Object source, HttpServletResponse res, Long id) 
	{
		super(source);
		this.response = res;
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}

	public HttpServletResponse getResponse() 
	{
		return response;
	}

}
