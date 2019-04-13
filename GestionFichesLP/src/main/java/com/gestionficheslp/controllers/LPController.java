package com.gestionficheslp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LPController {

	@RequestMapping("/index")
	public String index(ModelMap model) {
		model.addAttribute("message", "BONJOUR ADRIEN ! Installe Eclipse ^^");
		return "index";
	}
}
