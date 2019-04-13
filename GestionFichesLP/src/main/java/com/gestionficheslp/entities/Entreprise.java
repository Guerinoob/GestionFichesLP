package com.gestionficheslp.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Entreprise {

	@Id
	@GeneratedValue
	private int id;

	@NotNull
	private String nom;

	private String adresse;

	private String codepostal;

	private String ville;

	private String telephone;

	@OneToMany(mappedBy = "entreprise")
	private List<Alternance> alternances;

	public Entreprise() {
		super();
	}

	public Entreprise(int id, @NotNull String nom, String adresse, String codepostal, String ville, String telephone,
			List<Alternance> alternances) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.codepostal = codepostal;
		this.ville = ville;
		this.telephone = telephone;
		this.alternances = alternances;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodepostal() {
		return codepostal;
	}

	public void setCodepostal(String codepostal) {
		this.codepostal = codepostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public List<Alternance> getAlternances() {
		return alternances;
	}

	public void setAlternances(List<Alternance> alternances) {
		this.alternances = alternances;
	}

	@Override
	public String toString() {
		return "Entreprise [id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", codepostal=" + codepostal
				+ ", ville=" + ville + ", telephone=" + telephone + ", alternances=" + alternances + "]";
	}

}
