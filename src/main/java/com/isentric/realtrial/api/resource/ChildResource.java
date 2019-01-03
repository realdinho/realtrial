package com.isentric.realtrial.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isentric.realtrial.api.event.EventService;
import com.isentric.realtrial.api.model.Child;
import com.isentric.realtrial.api.service.ChildService;


@RestController
@RequestMapping("children")
public class ChildResource 
{
	@Autowired
	private ChildService childService;
	
	@Autowired
	private ApplicationEventPublisher eventPublisher;
	
	@PostMapping
	public ResponseEntity<Child> createChild(@Valid @RequestBody Child child, HttpServletResponse response)
	{
		Child createdChild = childService.createChild(child);
		
		eventPublisher.publishEvent(new EventService(this, response, child.getChildId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(createdChild);
	}

	@GetMapping
	public ResponseEntity<?> getChildren()
	{
		List<Child> childrenList = childService.findAllChildren();
		
		return childrenList.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok().body(childrenList);
	}
	
	@GetMapping("/{childId}")
	public ResponseEntity<?> getChildrenById(@PathVariable Long childId)
	{
		Child child = childService.findChildById(childId);
		
		return child == null ? ResponseEntity.noContent().build() : ResponseEntity.ok().body(child); 
	}
	
	@PutMapping("/{childId}")
	public ResponseEntity<?> updateChild(@PathVariable Long childId, @Valid @RequestBody Child newChild)
	{
		Child updatedChild = childService.updateChild(childId, newChild);
		
		return ResponseEntity.ok(updatedChild);
	}
}
