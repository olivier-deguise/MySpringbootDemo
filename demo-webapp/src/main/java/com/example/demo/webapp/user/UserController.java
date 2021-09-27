package com.example.demo.webapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	@Autowired UserService userService;
	
	@GetMapping("/listUsers")
	public String listUsers(Model model) {
		Iterable<User> listUsers = userService.getUsers();
		model.addAttribute("users", listUsers);
		
		return "viewUsers";
	}
	
	@GetMapping("/")
	public String home(Model model) {
		
		return "home";
	}

}
