package com.gestionficheslp.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Maitredestage extends User {

	@NotNull
	private String nom;
	@NotNull
	private String prenom;

	private String telephone;

	@NotNull
	private String mail;

	private String password;

	@OneToMany(mappedBy = "maitredestage")
	private List<Alternance> alternances;

	public Maitredestage() {
		super();
	}

	public Maitredestage(@NotNull String nom, @NotNull String prenom, String telephone, @NotNull String mail,
			String password, List<Alternance> alternances) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.mail = mail;
		this.password = password;
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Alternance> getAlternances() {
		return alternances;
	}

	public void setAlternances(List<Alternance> alternances) {
		this.alternances = alternances;
	}

	@Override
	public String toString() {
		return "Maitredestage [nom=" + nom + ", prenom=" + prenom + ", telephone=" + telephone + ", mail=" + mail
				+ ", password=" + password + ", alternances=" + alternances + "]";
	}

}
