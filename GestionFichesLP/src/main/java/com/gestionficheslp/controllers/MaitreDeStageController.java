package com.gestionficheslp.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.gestionficheslp.entities.Maitredestage;
import com.gestionficheslp.entities.User;
import com.gestionficheslp.repositories.MaitredestageRepository;



@Controller
@RequestMapping("/maitredestage")
public class MaitreDeStageController {
	
	@Autowired
	private MaitredestageRepository maitreDeStageRepository;
	
	@RequestMapping("/login")
	public String loginForm() {
		return "maitredestage/loginForm";
	}
	
	
	@PostMapping("/loginPost")
	public RedirectView loginPost(HttpServletRequest request, HttpSession session) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Maitredestage user = maitreDeStageRepository.findByUsername(username);
		
		if(BCrypt.checkpw(password, user.getPassword())) {
			session.setAttribute("user", (User)user);
			return new RedirectView("/login"); 
		}
		else
			return new RedirectView("/login");
	}

}
