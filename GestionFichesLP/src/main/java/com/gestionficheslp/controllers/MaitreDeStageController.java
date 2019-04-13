package com.gestionficheslp.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;



@Controller
@RequestMapping("/maitredestage")
public class MaitreDeStageController {
	
	@Autowired
	private MaitreDeStageRepository maitreDeStageRepository;
	
	@RequestMapping("/login")
	public String loginForm() {
		return "maitredestage/loginForm";
	}
	
	
	@PostMapping("/loginPost")
	public RedirectView loginPost(HttpServletRequest request, HttpSession session) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		MaitreDeStage user = maitreDeStageRepository.findByUsername(username);
		
		if(BCrypt.checkpw(password, user.getPassword())) {
			session.setAttribute("user", (User)user);
		}
		else
			return new RedirectView("/login");
	}

}
