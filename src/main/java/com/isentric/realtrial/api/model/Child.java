package com.isentric.realtrial.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "child")
public class Child 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "child_id")
	private Long childId;
	
	@NotNull
	private String name;
	
	private String email;
	
	@Column(name = "mobile_number")
	private String mobileNumber;
	
	private String picture;

	public Long getChildId() 
	{
		return childId;
	}

	public void setChildId(Long childId) 
	{
		this.childId = childId;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getMobileNumber() 
	{
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) 
	{
		this.mobileNumber = mobileNumber;
	}

	public String getPicture() 
	{
		return picture;
	}

	public void setPicture(String picture) 
	{
		this.picture = picture;
	}
	
}
