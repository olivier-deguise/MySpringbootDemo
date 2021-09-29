package com.example.demo.webapp.invoice;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.webapp.user.User;
import com.example.demo.webapp.user.UserService;

@Controller
public class InvoiceController {

	@Autowired InvoiceService invoiceService;
	@Autowired UserService userService;
	
	@PostMapping("/saveOrUpdateInvoice")
	public String saveOrUpdateInvoice(@ModelAttribute Invoice invoice, @RequestParam("userid") String userId, Model model) {
		User user = userService.getUser(Integer.valueOf(userId));
		invoice.setUser(user);
		user.getInvoices().add(invoice);
		
		userService.saveUser(user);
		model.addAttribute("user", userService.getUser(Integer.valueOf(userId)));
		
		//model.addAttribute("modeInvoice", "CREATE");
		
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
	
	@GetMapping("/deleteInvoice/{userid}/{id}")
	public String deleteInvoice(@PathVariable("id") int id, @PathVariable("userid") int userId, Model model) {
		User user = userService.getUser(userId);
		for(Invoice i : user.getInvoices() ) {
			if(i.getId() == id) {
				user.getInvoices().remove(i);
				break;
			}
		}
		userService.saveUser(user);
		
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
	
	@GetMapping("/viewAddInvoice/{id}")
	public String viewAddInvoice(@PathVariable("id") final int id, Model model) {
		User user = userService.getUser(id);
		model.addAttribute("user", user);
		
		model.addAttribute("invoice", new Invoice());
		model.addAttribute("modeInvoice", "CREATE");
		
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
	
}
