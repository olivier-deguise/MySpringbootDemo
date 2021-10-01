package com.example.demo.api.loginuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginUserController {

	@Autowired LoginUserService loginUserService;
	
	@GetMapping("/loginUsers")
	public Iterable<LoginUser> getUsers(){
		return loginUserService.getLoginUsers();
	}
	
	@GetMapping("/loginUser/{username}")
	public LoginUser getUser(@PathVariable("username") final String username){
		return loginUserService.getLoginUserByUsername(username);
	}
	
}
