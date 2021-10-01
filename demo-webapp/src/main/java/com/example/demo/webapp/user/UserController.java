package com.example.demo.webapp.user;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.webapp.invoice.Invoice;

@Controller
public class UserController {
	
	@Autowired UserService userService;
	
	@RolesAllowed("USER")
	@GetMapping("/listUsers")
	public String listUsers(Model model) {
		Iterable<User> listUsers = userService.getUsers();
		model.addAttribute("users", listUsers);
		
		return "viewUsers";
	}
	
	@RolesAllowed("ADMIN")
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
	
	@RolesAllowed("USER")
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
	
	@RolesAllowed("ADMIN")
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
	
	@RolesAllowed("ADMIN")
	@PostMapping("/saveOrUpdateUser")
	public ModelAndView saveOrUpdateUser(@Valid User user, BindingResult result, Model model, @RequestParam("mode") String mode) {
		if(userService.getUser(user.getId().intValue()) != null) {
			List<Invoice> invoices = userService.getUser(user.getId().intValue()).getInvoices();
			user.setInvoices(invoices);
		}
		
		if(result.hasErrors()) {
			model.addAttribute("user", user);
			model.addAttribute("mode", mode);
			
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
			return new ModelAndView("viewUser");
		}
		
		userService.saveUser(user);
		return new ModelAndView("redirect:/listUsers");
	}
	
	@RolesAllowed("ADMIN")
	@GetMapping("/deleteUser/{id}")
	public ModelAndView deleteUser(@PathVariable("id") final Long id) {
		userService.deleteUser(id);
		return new ModelAndView("redirect:/listUsers");
	}
	
	@RolesAllowed(value = {"USER","ADMIN"})
	@GetMapping("/")
	public String home(Model model) {
		
		return "home"; 
	}
	
	@GetMapping("/login")
	public String login() {
		
		return "login"; 
	}	

}
