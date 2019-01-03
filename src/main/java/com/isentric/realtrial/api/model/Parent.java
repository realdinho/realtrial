package com.isentric.realtrial.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "parent")
public class Parent 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "parent_id")
	private Long parentId; 
	
	@NotNull
	private String name;
	
	private String email;
	
	private String picture;
	
	@Column(name = "mobile_number")
	private String mobileNumber;

	public Long getParentId() 
	{
		return parentId;
	}

	public void setParentId(Long parentId) 
	{
		this.parentId = parentId;
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

	@Override
	public String toString() {
		return "Parent [parentId=" + parentId + ", name=" + name + ", email=" + email + ", picture=" + picture
				+ ", mobileNumber=" + mobileNumber + "]";
	}
	
	
}
