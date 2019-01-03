package com.isentric.realtrial.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.isentric.realtrial.api.model.Child;
import com.isentric.realtrial.api.repository.ChildRepository;

@Service
public class ChildService 
{
	@Autowired
	private ChildRepository childRepo;
	
	// add child to the database
	public Child createChild(Child child)
	{
		return childRepo.save(child);
	}
	
	// retrieve all children 
	public List<Child> findAllChildren()
	{
		return childRepo.findAll();
	}
	
	// retrieve all names of children
	public List<String> findChildrenNames()
	{
		List<String> childrenNames = new ArrayList<>();
		
		for(Child c: findAllChildren())
		{
			childrenNames.add(c.getName());
		}
		
		return childrenNames;
	}
	
	// retrieve child by 
	public Child findChildById(Long childId)
	{
		return childRepo.findById(childId).isPresent() ? childRepo.findById(childId).get() : null;
	}
	
	// edit child
	public Child updateChild(Long childId, Child newChild)
	{
		Child child = findChildById(childId);
		
		if(child == null)
		{
			throw new EmptyResultDataAccessException(1);
		}
		
		BeanUtils.copyProperties(newChild, child, "childId");
		
		return childRepo.save(child); 
	}
	
	// delete child 
	public void deleteChild(Long childId)
	{
		childRepo.deleteById(childId);
	}
}
