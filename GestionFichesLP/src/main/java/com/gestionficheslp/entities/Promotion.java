package com.gestionficheslp.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Promotion {

	@Id
	@GeneratedValue
	private int id;

	@NotNull
	private String annee;

	@OneToMany(mappedBy = "promotion")
	private List<Etudiant> etudiants;

	public Promotion() {
		super();
	}

	public Promotion(int id, @NotNull String annee, List<Etudiant> etudiants) {
		super();
		this.id = id;
		this.annee = annee;
		this.etudiants = etudiants;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnnee() {
		return annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}

	public List<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}

	@Override
	public String toString() {
		return "Promotion [id=" + id + ", annee=" + annee + ", etudiants=" + etudiants + "]";
	}

}
