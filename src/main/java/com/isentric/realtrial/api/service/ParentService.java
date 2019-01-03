package com.isentric.realtrial.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.isentric.realtrial.api.model.Parent;
import com.isentric.realtrial.api.repository.ParentRepository;

@Service
public class ParentService 
{
	@Autowired
	private ParentRepository parentRepo;
	
	// add parent to the database
	public Parent createparent(Parent parent)
	{
		return parentRepo.save(parent);
	}
	
	// retrieve all parents from the database
	public List<Parent> findParents()
	{
		return parentRepo.findAll();
	}
	
	public List<String> findParentNames()
	{
		List<String> parentNames = new ArrayList<>();
		
		for(Parent p : findParents())
		{
			parentNames.add(p.getName());
		}
		
		return parentNames;
	}
	
	// retrieve parent by ID
	public Parent findParentById(Long parentId)
	{
		return parentRepo.findById(parentId).orElse(null);
	}
	
	// edit parent in the database
	public Parent updateParent(Long parentId, Parent newParent)
	{
		Parent parent = findParentById(parentId);
		
		if(parent == null)
		{
			throw new EmptyResultDataAccessException(1);
		}
		
		BeanUtils.copyProperties(newParent, parent, "parentId");
		
		return parentRepo.save(parent);
	}
	
	// delete parent
	public void deleteParent(Long parentId)
	{
		parentRepo.deleteById(parentId);
	}
}
