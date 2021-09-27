package com.example.demo.webapp.user;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	
	@Autowired UserService userService;
	
	@GetMapping("/listUsers")
	public String listUsers(Model model) {
		Iterable<User> listUsers = userService.getUsers();
		model.addAttribute("users", listUsers);
		
		return "viewUsers";
	}
	
	@GetMapping("/viewUpdateUser/{id}")
	public String viewUpdateUser(@PathVariable("id") final int id, Model model) {
		User user = userService.getUser(id);
		model.addAttribute("user", user);
		
		model.addAttribute("mode", "EDIT");
		Map<String, String> genderMap = new LinkedHashMap<String, String>();
		genderMap.put("M", "Homme");
		genderMap.put("F", "Femme");
		model.addAttribute("genderMap", genderMap);
		
		Map<String, String> countryMap = new LinkedHashMap<String, String>();
		countryMap.put("0", "Sélectionner un pays");
		countryMap.put("CA", "Canada");
		countryMap.put("USA", "États-Unis");
		countryMap.put("MEX", "Mexique");
		model.addAttribute("countryMap", countryMap);		
		
		return "viewUser";
	}
	
	@GetMapping("/viewUser/{id}")
	public String viewUser(@PathVariable("id") final int id, Model model) {
		User user = userService.getUser(id);
		model.addAttribute("user", user);
		
		model.addAttribute("mode", "VIEW");
		Map<String, String> genderMap = new LinkedHashMap<String, String>();
		genderMap.put("M", "Homme");
		genderMap.put("F", "Femme");
		model.addAttribute("genderMap", genderMap);
		
		Map<String, String> countryMap = new LinkedHashMap<String, String>();
		countryMap.put("0", "Sélectionner un pays");
		countryMap.put("CA", "Canada");
		countryMap.put("USA", "États-Unis");
		countryMap.put("MEX", "Mexique");
		model.addAttribute("countryMap", countryMap);
		
		model.addAttribute("disableField", Boolean.valueOf(true));
		
		return "viewUser";
	}	
	
	@GetMapping("/viewAddUser")
	public String viewAddUser(Model model) {
		
		model.addAttribute("mode", "CREATE");
		model.addAttribute("user", new User());
		
		Map<String, String> genderMap = new LinkedHashMap<String, String>();
		genderMap.put("M", "Homme");
		genderMap.put("F", "Femme");
		model.addAttribute("genderMap", genderMap);
		
		Map<String, String> countryMap = new LinkedHashMap<String, String>();
		countryMap.put("0", "Sélectionner un pays");
		countryMap.put("CA", "Canada");
		countryMap.put("USA", "États-Unis");
		countryMap.put("MEX", "Mexique");
		model.addAttribute("countryMap", countryMap);		
		
		return "viewUser";
	}
	
	@PostMapping("/saveOrUpdateUser")
	public ModelAndView saveOrUpdateUser(@ModelAttribute User user) {
		userService.saveUser(user);
		return new ModelAndView("redirect:/listUsers");
	}
	
	@GetMapping("/deleteUser/{id}")
	public ModelAndView deleteUser(@PathVariable("id") final Long id) {
		userService.deleteUser(id);
		return new ModelAndView("redirect:/listUsers");
	}
	
	@GetMapping("/")
	public String home(Model model) {
		
		return "home"; 
	}

}
