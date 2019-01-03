package com.isentric.realtrial.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.isentric.realtrial.api.event.EventService;
import com.isentric.realtrial.api.model.Parent;
import com.isentric.realtrial.api.service.ParentService;


@RestController
@RequestMapping("parents")
public class ParentResource 
{
	@Autowired
	private ParentService parentService;
	
	@Autowired
	private ApplicationEventPublisher eventPublisher;
	
	@PostMapping
	public ResponseEntity<Parent> createParent(@Valid @RequestBody Parent parent, HttpServletResponse response)
	{
		Parent createdParent = parentService.createparent(parent);
		
		eventPublisher.publishEvent(new EventService(this, response, createdParent.getParentId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(createdParent);
	}
	
	@GetMapping
	public ResponseEntity<?> getParents()
	{
		List<Parent> parents = parentService.findParents();
		
		return parents.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok().body(parents);
	}
	
	@GetMapping("/{parentId}")
	public ResponseEntity<Parent> getParentById(@PathVariable Long parentId)
	{
		Parent parent = parentService.findParentById(parentId);
		
		return parent == null ? ResponseEntity.noContent().build() : ResponseEntity.ok().body(parent);
	}
	
	@PutMapping("/{parentId}")
	public ResponseEntity<Parent> updateParent(@PathVariable Long parentId, @Valid @RequestBody Parent newParent)
	{
		Parent updatedParent = parentService.updateParent(parentId, newParent);
		
		return ResponseEntity.ok(updatedParent);
	}
	
	@DeleteMapping("/{parentId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteParent(@PathVariable Long parentId)
	{
		parentService.deleteParent(parentId);
	}
}
