package com.gestionficheslp.controllers;

import com.gestionficheslp.entities.Fiche;
import com.gestionficheslp.repositories.FicheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

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

    /**
     * Permet de récuperer les données de la fonction add
     * @param request
     * @return
     */
    @PostMapping("/addPost")
    public RedirectView addPost(HttpServletRequest request) {
        try {
            ArrayList<String> listeNom = getAllChampsNom("Fiche/Configuration.xml",1);
            String xml ="<xml>";
            for (int i = 0; i < listeNom.size(); i++) {
                String nom = listeNom.get(i);
                String balise = "";
                //Certains champs contiennent un chiffre on veut donc le supprimer lors que c'est nécessaire
                if(!nom.matches("[a-zA-Z]+")){
                    balise = nom.substring(0,nom.length()-1);
                }else{
                    balise = nom;
                }
                xml += "<"+balise+">";
                xml += request.getParameter(nom);
                xml += "</"+balise+">";
            }

            xml += "</xml>";
            Fiche fiche = new Fiche();
            ficheRepository.save(fiche);
            List<String> lines = new ArrayList<>();
            lines.add(xml);
            Path file = Paths.get("Fiche/"+fiche.getId()+".xml");
            Files.write(file, lines, Charset.forName("UTF-8"));

        }catch(Exception e){
            return new RedirectView("/fiche/add");
        }
        return new RedirectView("/index");
    }

    /**
     *
     * @param filePath le ficher de configuration
     * @param periode La période de la fiche
     * @return tous les champs qui sont censé appraitre pour la période
     */
    private static ArrayList<String> getAllChampsNom(String filePath,int periode){
        Document doc = convertXMLFileToXMLDocument(filePath);
        NodeList liste = doc.getChildNodes().item(0).getChildNodes();//On récupère tous les enfants de la balise principale
        ArrayList<Integer> tab = new ArrayList<>(); //Contient le numéro des champs qui sont dans le tableau du début
        ArrayList<String> champsNom = new ArrayList<>(); //Pour retourner tous les champs
        int quantite =0; //Permet de savoir le nombre de champs dans le tableau

        for (int i = 0; i < liste.getLength() ; i++) {
            if(liste.item(i).getNodeName().equals("Table")){ //Récupération de la balise table
                NodeList table = liste.item(i).getChildNodes(); // Les enfants de table
                for (int j = 0; j < table.getLength() ; j++) {
                    if(table.item(j).getNodeName().equals("Quantite")) {
                        quantite = Integer.parseInt(table.item(j).getTextContent()); //On met le champs quantité dans la variable
                    }
                    if(table.item(j).getNodeName().equals("Champs")){
                        tab.add(Integer.parseInt(table.item(j).getTextContent())*2+9); /*On récupère pour chaque champs sa position qu'on multiplie par 2
                        et auquel on ajoute 9 pour faire correspondre avec l'arboresence du Xml
                        On ajoute ce résultat au tableau prévu à cet effet*/
                    }
                }
                //On veut que tous les champs dans le tableau apparaissent sous la forme champA1 champB1 champA2 champB2..
                for (int j = 1; j < quantite+1; j++) {
                    for (Integer in:tab) {
                        if(champsGoodPeriode(liste.item(in),periode)){
                            champsNom.add(getNomChamps(liste.item(in))+j); //On ajoute au nom du champ la variable J pour obtenir champ1 champ2 ..
                        }
                    }
                }

            }
            // On ne récupère pas les champs qui ont déjà été pris dans le tableau
            if(!tab.contains(i) && liste.item(i).getNodeName().equals("Champs") && champsGoodPeriode(liste.item(i),periode)){
                champsNom.add(getNomChamps(liste.item(i)));
            }
        }
        return champsNom;
    }

    /**
     *
     * @param node de type Champs pour itérer dessus
     * @return le nom du champ en question
     */
    private static String getNomChamps(Node node){
        NodeList liste = node.getChildNodes();
        for (int i = 0; i < liste.getLength(); i++) {
            if(liste.item(i).getNodeName().equals("Nom")){
                return liste.item(i).getTextContent();
            }
        }
        return "";
    }

    /**
     * Permet de savoir si le champ doit être affiché
     * @param node de type Champs
     * @param periode la période en cours
     * @return vrai si le champ est dans la période actuelle
     */
    private static boolean champsGoodPeriode(Node node,int periode) {
        NodeList liste = node.getChildNodes();
        for (int i = 0; i < liste.getLength(); i++) {
            if (liste.item(i).getNodeName().equals("Periode")) {
                NodeList listPeriode = liste.item(i).getChildNodes();
                for (int j = 0; j < listPeriode.getLength(); j++) {
                    if (listPeriode.item(j).getNodeName().equals("Numero") && Integer.parseInt(listPeriode.item(j).getTextContent()) == periode) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Convertit un XML String en document
     * @param filePath
     * @return
     */
    private static Document convertXMLFileToXMLDocument(String filePath) {
        //Parser that produces DOM object trees from XML content
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        //API to obtain DOM Document instance
        DocumentBuilder builder = null;
        try {
            //Create DocumentBuilder with default configuration
            builder = factory.newDocumentBuilder();

            //Parse the content to Document object
            Document doc = builder.parse(new File(filePath));
            return doc;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
