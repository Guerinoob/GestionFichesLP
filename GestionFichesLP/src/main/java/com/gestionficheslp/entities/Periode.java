package com.gestionficheslp.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Periode {

	@Id
	@GeneratedValue
	private int id;

	@NotNull
	private int trimestre;

	@NotNull
	private String datedebut;

	@OneToMany(mappedBy = "periode")
	private List<Fiche> fiches;

	public Periode() {
		super();
	}

	public Periode(@NotNull int trimestre, @NotNull String datedebut, List<Fiche> fiches) {
		super();
		this.id = id;
		this.trimestre = trimestre;
		this.datedebut = datedebut;
		this.fiches = fiches;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTrimestre() {
		return trimestre;
	}

	public void setTrimestre(int trimestre) {
		this.trimestre = trimestre;
	}

	public String getDatedebut() {
		return datedebut;
	}

	public void setDatedebut(String datedebut) {
		this.datedebut = datedebut;
	}

	public List<Fiche> getFiches() {
		return fiches;
	}

	public void setFiches(List<Fiche> fiches) {
		this.fiches = fiches;
	}

	@Override
	public String toString() {
		return "Periode [id=" + id + ", trimestre=" + trimestre + ", datedebut=" + datedebut + ", fiches=" + fiches
				+ "]";
	}

}
