package com.gestionficheslp.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gestionficheslp.entities.Alternance;
import com.gestionficheslp.entities.Entreprise;
import com.gestionficheslp.entities.Etudiant;
import com.gestionficheslp.entities.Maitredestage;
import com.gestionficheslp.entities.Promotion;
import com.gestionficheslp.entities.Tuteuriut;
import com.gestionficheslp.repositories.AlternanceRepository;
import com.gestionficheslp.repositories.EntrepriseRepository;
import com.gestionficheslp.repositories.EtudiantRepository;
import com.gestionficheslp.repositories.MaitredestageRepository;
import com.gestionficheslp.repositories.PromotionRepository;
import com.gestionficheslp.repositories.TuteuriutRepository;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private PromotionRepository promotionRepository;
	
	@Autowired
	private EtudiantRepository etudiantRepository;
	
	@Autowired
	private MaitredestageRepository maitredestageRepository;
	
	@Autowired
	private EntrepriseRepository entrepriseRepostiory;
	
	@Autowired
	private AlternanceRepository alternanceRepository;
	
	@Autowired
	private TuteuriutRepository tuteuriutRepository;
	
	@RequestMapping("/createUsers")
	public @ResponseBody String createUsers() {
		
		Promotion promo = new Promotion("2018", null);
		promo = promotionRepository.save(promo);
		
		Entreprise entreprise = new Entreprise("Alexandre MAUROUARD Freelance", "52 Saint-Gabriel", "14000", "Caen", "0707070707", null);
		entreprise = entrepriseRepostiory.save(entreprise);
		
		Etudiant etu = new Etudiant("OZDEN", "Romain", promo, null);
		etu = etudiantRepository.save(etu);
		
		Maitredestage maitre = new Maitredestage("MAUROUARD", "Alexandre", "0606060606", "contact@alexandremaurouard.fr", BCrypt.hashpw("password", BCrypt.gensalt()), null);
		maitre = maitredestageRepository.save(maitre);
		
		Tuteuriut tuteur = new Tuteuriut("PASSONI-CHEVALIER", "Christelle", false, null);
		tuteur = tuteuriutRepository.save(tuteur);
		
		List<Tuteuriut> tuteurs = new ArrayList<Tuteuriut>();
		tuteurs.add(tuteur);
		
		Alternance alternance = new Alternance("14/04/2019", "21/04/2019", etu, maitre, entreprise, null, tuteurs);
		alternance = alternanceRepository.save(alternance);
		
		return "c fini";
	}

}
