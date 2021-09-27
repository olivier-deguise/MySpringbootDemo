package com.example.demo.api.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.invoice.Invoice;

@RestController
public class UserController {
	
	@Autowired UserService userService;
	

	@PostMapping("/user")
	public User createUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable("id") final Long id) {
		Optional<User> user = userService.getUser(id);
		if(user.isPresent()) {
			return user.get();
		} else {
			return null;
		}
	}	
	
	@GetMapping("/users")
	public Iterable<User> getUsers(){
		return userService.getUsers();
	}
	
	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable("id") final Long id) {
		userService.deleteUser(id);
	}
	
	@PutMapping("/user/{id}")
	public User updateUser(@PathVariable("id") final Long id, @RequestBody User user) {
		Optional<User> u = userService.getUser(id);
		if(u.isPresent()) {
			User currentUser = u.get();
			
			String name = user.getName();
			if(name != null) {
				currentUser.setName(name);
			}
			Boolean mailingList = user.getMailingList();
			if(mailingList != null) {
				currentUser.setMailingList(mailingList);
			}
			String gender = user.getGender();
			if(gender != null) {
				currentUser.setGender(gender);
			}
			String country = user.getCountry();
			if(country != null) {
				currentUser.setCountry(country);;
			}
			String city = user.getCity();
			if(city != null) {
				currentUser.setCity(city);;
			}
			String aboutYou = user.getAboutYou();
			if(aboutYou != null) {
				currentUser.setAboutYou(aboutYou);
			}		
			List<Invoice> invoices = user.getInvoices();
			if(invoices != null) {
				currentUser.setInvoices(invoices);
			}	
			userService.saveUser(currentUser);
			return currentUser;
		} else {
			return null;
		}
	}	

}
