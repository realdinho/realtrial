package com.isentric.realtrial.api.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//@Entity
//@Table(name = "parent_child")
public class ParentChild 
{
	@Id
	@ManyToOne
	@JoinColumn(name = "parent_id")
	private Parent parent;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "child_id")
	private Child child;

	public Parent getParent() 
	{
		return parent;
	}

	public void setParent(Parent parent) 
	{
		this.parent = parent;
	}

	public Child getChild() 
	{
		return child;
	}

	public void setChild(Child child) 
	{
		this.child = child;
	}
}
