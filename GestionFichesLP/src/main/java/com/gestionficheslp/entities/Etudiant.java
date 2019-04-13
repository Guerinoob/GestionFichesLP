package com.gestionficheslp.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Etudiant extends User {

	@NotNull
	private String nom;

	@NotNull
	private String prenom;

	@ManyToOne
	private Promotion promotion;

	@OneToMany(mappedBy = "etudiant")
	private List<Alternance> alternances;

	public Etudiant() {
		super();
	}

	public Etudiant(@NotNull String nom, @NotNull String prenom, Promotion promotion, List<Alternance> alternances) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.promotion = promotion;
		this.alternances = alternances;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	public List<Alternance> getAlternances() {
		return alternances;
	}

	public void setAlternances(List<Alternance> alternances) {
		this.alternances = alternances;
	}

	@Override
	public String toString() {
		return "Etudiant [nom=" + nom + ", prenom=" + prenom + ", promotion=" + promotion + ", alternances="
				+ alternances + "]";
	}

}
