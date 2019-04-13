package com.gestionficheslp.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Tuteuriut extends User {

	@NotNull
	private String nom;

	@NotNull
	private String prenom;

	@NotNull
	private boolean Admin;

	@ManyToMany(mappedBy = "tuteurs")
	private List<Alternance> alternances;

	public Tuteuriut() {
		super();
	}

	public Tuteuriut(@NotNull String nom, @NotNull String prenom, @NotNull boolean admin,
			List<Alternance> alternances) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		Admin = admin;
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

	public boolean isAdmin() {
		return Admin;
	}

	public void setAdmin(boolean admin) {
		Admin = admin;
	}

	public List<Alternance> getAlternances() {
		return alternances;
	}

	public void setAlternances(List<Alternance> alternances) {
		this.alternances = alternances;
	}

	@Override
	public String toString() {
		return "Tuteuriut [nom=" + nom + ", prenom=" + prenom + ", Admin=" + Admin + ", alternances=" + alternances
				+ "]";
	}

}
