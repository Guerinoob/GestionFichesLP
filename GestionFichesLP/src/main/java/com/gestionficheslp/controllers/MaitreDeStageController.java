package com.gestionficheslp.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.gestionficheslp.entities.Alternance;
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
			return new RedirectView("index"); 
		}
		else
			return new RedirectView("login");
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		session.setAttribute("user", null);
		return new ModelAndView("redirect:login");
	}
	
	@RequestMapping("/index")
	public ModelAndView index(HttpSession session) {
		Maitredestage user;
		
		if((user = (Maitredestage) session.getAttribute("user")) == null)
			return new ModelAndView("redirect:login");
		
		ModelAndView model = new ModelAndView("maitredestage/index");
		model.addObject("user", user);
		
		return model;
	}
	
	
	@RequestMapping("/voirAlternances")
	public ModelAndView voirAlternances(HttpSession session) {
		Maitredestage user;
		
		if((user = (Maitredestage) session.getAttribute("user")) == null)
			return new ModelAndView("redirect:login");
		
		user = maitreDeStageRepository.findById(user.getId()).get();
		
		ModelAndView model = new ModelAndView("maitredestage/voirAlternances");
		model.addObject("user", user);
		
		return model;
	}
}
