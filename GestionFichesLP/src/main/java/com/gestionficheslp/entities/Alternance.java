package com.gestionficheslp.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Alternance {

	@Id
	@GeneratedValue
	private int id;

	private String DateDebut;

	private String DateFin;

	@ManyToOne
	private Etudiant etudiant;

	@ManyToOne
	private Maitredestage maitredestage;

	@ManyToOne
	private Entreprise entreprise;

	@OneToMany(mappedBy = "alternance")
	private List<Fiche> fiches;

	@ManyToMany
	private List<Tuteuriut> tuteurs;

	public Alternance() {
		super();
	}

	public Alternance(String dateDebut, String dateFin, Etudiant etudiant, Maitredestage maitredestage,
			Entreprise entreprise, List<Fiche> fiches, List<Tuteuriut> tuteurs) {
		super();
		DateDebut = dateDebut;
		DateFin = dateFin;
		this.etudiant = etudiant;
		this.maitredestage = maitredestage;
		this.entreprise = entreprise;
		this.fiches = fiches;
		this.tuteurs = tuteurs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDateDebut() {
		return DateDebut;
	}

	public void setDateDebut(String dateDebut) {
		DateDebut = dateDebut;
	}

	public String getDateFin() {
		return DateFin;
	}

	public void setDateFin(String dateFin) {
		DateFin = dateFin;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public Maitredestage getMaitredestage() {
		return maitredestage;
	}

	public void setMaitredestage(Maitredestage maitredestage) {
		this.maitredestage = maitredestage;
	}

	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	public List<Fiche> getFiches() {
		return fiches;
	}

	public void setFiches(List<Fiche> fiches) {
		this.fiches = fiches;
	}

	public List<Tuteuriut> getTuteurs() {
		return tuteurs;
	}

	public void setTuteurs(List<Tuteuriut> tuteurs) {
		this.tuteurs = tuteurs;
	}

	@Override
	public String toString() {
		return "Alternance [id=" + id + ", DateDebut=" + DateDebut + ", DateFin=" + DateFin + ", etudiant=" + etudiant
				+ ", maitredestage=" + maitredestage + ", entreprise=" + entreprise + ", fiches=" + fiches
				+ ", tuteurs=" + tuteurs + "]";
	}

}
