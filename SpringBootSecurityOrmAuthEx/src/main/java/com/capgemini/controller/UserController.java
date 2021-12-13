package com.capgemini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.capgemini.model.User;
import com.capgemini.services.IUserService;

@Controller
public class UserController {
	
	@Autowired
	private IUserService service;

	@GetMapping("/reg")
	public String showReg() {
		return "UserRegister";
	}
	
	@PostMapping("/save")
	public String saveUser(@ModelAttribute User user, Model modle) {
		Integer id = service.save(user);
		String msg = "User '"+id+"' saved successfully.";
		modle.addAttribute("message",msg);
		
		return "UserRegister";
	}
}
