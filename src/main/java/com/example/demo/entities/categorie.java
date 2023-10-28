package com.example.demo.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class categorie {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;
	
	

private String nomC;




public long getIdCategorie() {
	return id;
}
public void setIdCategorie(long id) {
	this.id = id;
}
public String getNomC() {
	return nomC;
}
public void setNomC(String nomC) {
	this.nomC = nomC;
}
public categorie(long id, String nomC) {
	super();
	this.id = id;
	this.nomC = nomC;
}


public categorie(long id, String nomC, List<offre> offres) {
	super();
	this.id = id;
	this.nomC = nomC;

}
public categorie(String nomC) {
	super();
	this.nomC = nomC;
}
public categorie() {
	super();
}
@Override
public String toString() {
	return "categorie [idCategorie=" + id + ", nomC=" + nomC + "]";
}


}
