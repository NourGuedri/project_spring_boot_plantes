package com.nour.plantes.entities;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

@Entity
public class Plante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPlante;

	@NotNull
	@Size (min = 4,max = 15)
	private String nomPlante;
	@Size (min = 4,max = 15)
	private String couleur;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@FutureOrPresent
	private Date dateRendezVous ;
	@ManyToOne
	private Type type;
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public Plante() {
	super();
	}
	public Plante(String nomPlante, String couleur, Date dateRendezVous) {
	super();
	this.nomPlante = nomPlante;
	this.couleur = couleur;
	this.dateRendezVous = dateRendezVous;
	}
	
	public Long getIdPlante() {
		return idPlante;
		}
		public void setIdPlante(Long idPlante) {
		this.idPlante = idPlante;
		}
		public String getNomPlante() {
		return nomPlante;
		}
		public void setNomPlante(String nomPlante) {
		this.nomPlante = nomPlante;
		}
		public String getCouleur() {
		return couleur;
		}
		public void setCouleur(String couleur) {
		this.couleur = couleur;
		}
	public Date getDateRendezVous() {
	return dateRendezVous;
	}
	public void setDateRendezVous(Date dateRendezVous) {
	this.dateRendezVous = dateRendezVous;
	}
	@Override
	public String toString() {
	return "Plante [idPlante=" + idPlante + ", nomPlante=" +nomPlante + ", couleur=" + couleur
	+ ", dateRendezVous=" + dateRendezVous + "]";
	}
	}