package com.isentric.realtrial.api;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.isentric.realtrial.api.service.ChildService;
import com.isentric.realtrial.api.service.ParentService;


@SpringBootApplication
public class RealTrialApplication 
{
	public static void main(String[] args) 
	{
		SpringApplication.run(RealTrialApplication.class, args);
	}
}


@Controller
class PageController
{
	@Autowired
	private ParentService parentService;
	
	@Autowired
	private ChildService childService;
	
	@GetMapping("/users/parents")
	public String getParentNames(Model model)
	{
		model.addAttribute("parents", parentService.findParentNames());
		
		return "parents";
	}
	
	@GetMapping("/users/children")
	public String getChildrenNames(Model model)
	{
		model.addAttribute("children", childService.findChildrenNames());
		
		return "children";
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) throws ServletException
	{
		request.logout();
		
		return "/";
	}
}

