package com.gestionficheslp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Fiche {

	@Id
	@GeneratedValue
	private int id;

	private String chemin;

	@NotNull
	private boolean valide;

	@NotNull
	private boolean visibleEtudiant;

	@NotNull
	private boolean visibleMaitredestage;

	@ManyToOne
	private Periode periode;

	@ManyToOne
	private Alternance alternance;

	public Fiche() {
		super();
	}

	public Fiche(int id, String chemin, @NotNull boolean valide, @NotNull boolean visibleEtudiant,
			@NotNull boolean visibleMaitredestage, Periode periode, Alternance alternance) {
		super();
		this.id = id;
		this.chemin = chemin;
		this.valide = valide;
		this.visibleEtudiant = visibleEtudiant;
		this.visibleMaitredestage = visibleMaitredestage;
		this.periode = periode;
		this.alternance = alternance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getChemin() {
		return chemin;
	}

	public void setChemin(String chemin) {
		this.chemin = chemin;
	}

	public boolean isValide() {
		return valide;
	}

	public void setValide(boolean valide) {
		this.valide = valide;
	}

	public boolean isVisibleEtudiant() {
		return visibleEtudiant;
	}

	public void setVisibleEtudiant(boolean visibleEtudiant) {
		this.visibleEtudiant = visibleEtudiant;
	}

	public boolean isVisibleMaitredestage() {
		return visibleMaitredestage;
	}

	public void setVisibleMaitredestage(boolean visibleMaitredestage) {
		this.visibleMaitredestage = visibleMaitredestage;
	}

	public Periode getPeriode() {
		return periode;
	}

	public void setPeriode(Periode periode) {
		this.periode = periode;
	}

	public Alternance getAlternance() {
		return alternance;
	}

	public void setAlternance(Alternance alternance) {
		this.alternance = alternance;
	}

	@Override
	public String toString() {
		return "Fiche [id=" + id + ", chemin=" + chemin + ", valide=" + valide + ", visibleEtudiant=" + visibleEtudiant
				+ ", visibleMaitredestage=" + visibleMaitredestage + ", periode=" + periode + ", alternance="
				+ alternance + "]";
	}

}
