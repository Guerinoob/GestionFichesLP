package com.gestionficheslp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gestionficheslp.entities.Etudiant;
import com.gestionficheslp.entities.Maitredestage;
import com.gestionficheslp.entities.Promotion;
import com.gestionficheslp.repositories.EtudiantRepository;
import com.gestionficheslp.repositories.MaitredestageRepository;
import com.gestionficheslp.repositories.PromotionRepository;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private PromotionRepository promotionRepository;
	
	@Autowired
	private EtudiantRepository etudiantRepository;
	
	@Autowired
	private MaitredestageRepository maitredestageRepository;
	
	@RequestMapping("/createUsers")
	public @ResponseBody String createUsers() {
		
		Promotion promo = new Promotion("2018", null);
		promo = promotionRepository.save(promo);
		
		Etudiant etu = new Etudiant("OZDEN", "Romain", promo, null);
		etu = etudiantRepository.save(etu);
		
		Maitredestage maitre = new Maitredestage("MAUROUARD", "Alexandre", "0606060606", "contact@alexandremaurouard.fr", "password", null);
		maitre = maitredestageRepository.save(maitre);
		
		return "c fini";
	}

}
