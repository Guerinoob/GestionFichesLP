package com.gestionficheslp.controllers;

import com.gestionficheslp.repositories.FicheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

@Controller
@RequestMapping("/fiche")
public class FicheController {
    @Autowired
    private FicheRepository ficheRepository;
    public String index(ModelMap model) {
        model.addAttribute("message", "BONJOUR ADRIEN ! Installe Eclipse ^^");
        return "index";
    }
    @RequestMapping("/add")
    public String add(ModelMap model) {
        //Fiche/Configuration.xml
        return "fiche/add";
    }
    @RequestMapping("/config")
    public ResponseEntity<String> config(){
        ResponseEntity<String> stringResponseEntity = new ResponseEntity<String>("i",HttpStatus.OK);
        try{
             byte[] encoded = Files.readAllBytes(Paths.get("Fiche/Configuration.xml"));
            String tg =  new String(encoded, StandardCharsets.UTF_8);
            stringResponseEntity = new ResponseEntity<String>(tg, HttpStatus.OK);
        }catch(Exception e){

        }

        return stringResponseEntity;
    }
}
