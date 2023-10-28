package com.example.demo.entities;

import java.sql.Date;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity

public class offre {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
private long idOffre;
private String nomcentre;

private String nomo;
private String Description;
private Double prix;
private Double ancienprix;
@Column(nullable = false)
private Date PromotionDate;
@Column(nullable = false)
private Integer duree;
private String imageo;

private String categorie;
private Integer quantite;



@JsonIgnore
@ManyToMany
@JoinTable(
    name = "achat",
    joinColumns = @JoinColumn(name = "idOffre"),
    inverseJoinColumns = @JoinColumn(name = "idUser")
)
private List<User> clients = new ArrayList<>();


public List<User> getClients() {
	return clients;
}
public void setClients(List<User> clients) {
	this.clients = clients;
}
public String getCategorie() {
	return categorie;
}
public void setCategorie(String categorie) {
	this.categorie = categorie;
}
public long getIdOffre() {
	return idOffre;
}
public void setIdOffre(long idOffre) {
	this.idOffre = idOffre;
}
public String getNomcentre() {
	return nomcentre;
}
public void setNomcentre(String nomcentre) {
	this.nomcentre = nomcentre;
}
public String getNomo() {
	return nomo;
}
public void setNomo(String nomo) {
	this.nomo = nomo;
}
public String getDescription() {
	return Description;
}
public void setDescription(String description) {
	this.Description = description;
}
public Double getPrix() {
	return prix;
}
public void setPrix(Double prix) {
	this.prix = prix;
}
public Date getPromotionDate() {
	return PromotionDate;
}
public void setPromotionDate(Date promotionDate) {
	this.PromotionDate = promotionDate;
}
public Integer getDuree() {
	return duree;
}
public void setDuree(Integer duree) {
	this.duree=duree;
}

public String getImageo() {
	return imageo;
}
public void setImageo(String imageo) {
	this.imageo = imageo;
}
public Integer getQuantite() {
	return quantite;
}
public void setQuantite(Integer quantite) {
	this.quantite = quantite;
}

public Double getAncienprix() {
	return ancienprix;
}
public void setAncienprix(Double ancienprix) {
	this.ancienprix = ancienprix;
}
public offre(long idOffre, String nomo, String description, Double prix, Date promotionDate, Integer duree,String imageo) {
	super();
	this.idOffre = idOffre;
	this.nomo = nomo;
	this.Description = description;
	this.prix = prix;
	this.PromotionDate = promotionDate;
	this.duree=duree;
	this.imageo = imageo;
}
public offre(String nomo, String description, Double prix, Date promotionDate,Integer duree, String imageo) {
	super();
	this.nomo = nomo;
	this.Description = description;
	this.prix = prix;
	this.PromotionDate = promotionDate;
	this.duree=duree;
	this.imageo = imageo;
}


public offre(long idOffre, String nomcentre, String nomo, String description, Double prix, Double ancienprix,
		Date promotionDate, Integer duree, String imageo, String categorie, Integer quantite, List<User> clients) {
	super();
	this.idOffre = idOffre;
	this.nomcentre = nomcentre;
	this.nomo = nomo;
	Description = description;
	this.prix = prix;
	this.ancienprix = ancienprix;
	PromotionDate = promotionDate;
	this.duree = duree;
	this.imageo = imageo;
	this.categorie = categorie;
	this.quantite = quantite;
	this.clients = clients;
}
public offre() {
	super();
}
@Override
public String toString() {
	return "offre [idOffre=" + idOffre + ", nomcentre=" + nomcentre + ", nomo=" + nomo + ", Description=" + Description
			+ ", prix=" + prix + ", ancienprix=" + ancienprix + ", PromotionDate=" + PromotionDate + ", duree=" + duree
			+ ", imageo=" + imageo + ", categorie=" + categorie + ", quantite=" + quantite + ", clients=" + clients
			+ "]";
}





}
