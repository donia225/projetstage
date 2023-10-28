package com.example.demo.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Achat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateachat;
    private float montantpaye;
    private String statut;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idUser")
    private User cliente;
    @JsonIgnore
	@ManyToOne
    @JoinColumn(name = "idOffre")
    private offre offre;

    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getCliente() {
		return cliente;
	}
	public void setCliente(User cliente) {
		this.cliente = cliente;
	}
	public offre getOffre() {
		return offre;
	}
	public void setOffre(offre offre) {
		this.offre = offre;
	}
	public Date getDateachat() {
		return dateachat;
	}
	public void setDateachat(Date dateachat) {
		this.dateachat = dateachat;
	}
	public float getMontantpaye() {
		return montantpaye;
	}
	public void setMontantpaye(float montantpaye) {
		this.montantpaye = montantpaye;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public Achat(Long id, Date dateachat, float montantpaye, String statut, User cliente,
			com.example.demo.entities.offre offre) {
		super();
		this.id = id;
		this.dateachat = dateachat;
		this.montantpaye = montantpaye;
		this.statut = statut;
		this.cliente = cliente;
		this.offre = offre;
	}
	public Achat(Date dateachat, float montantpaye, String statut, User cliente,
			com.example.demo.entities.offre offre) {
		super();
		this.dateachat = dateachat;
		this.montantpaye = montantpaye;
		this.statut = statut;
		this.cliente = cliente;
		this.offre = offre;
	}
	@Override
	public String toString() {
		return "Achat [id=" + id + ", dateachat=" + dateachat + ", montantpaye=" + montantpaye + ", statut=" + statut
				+ ", cliente=" + cliente + ", offre=" + offre + "]";
	}


    
}
