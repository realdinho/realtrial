package com.isentric.realtrial.api.event;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@Component
public class ListenerService implements ApplicationListener<EventService>
{

	@Override
	public void onApplicationEvent(EventService event) 
	{
		addHeaderLocation(event.getResponse(), event.getId());
	}

	private void addHeaderLocation(HttpServletResponse response, Long id) 
	{
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(id).toUri();
		response.setHeader("Location", uri.toASCIIString());
	}

}
