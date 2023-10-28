
package com.example.demo.entities;

import java.util.ArrayList;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class User {
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
private Long idUser;

@Enumerated(EnumType.STRING)
private UserRole role;
private String nom;
private String prenom;
private String email;
private String numtel;
private String adresse;
private String password;
private int codepostal;
private String ville;

@JsonIgnore
@ManyToMany(mappedBy = "clients")
private List<offre> achats = new ArrayList<>();  

public List<offre> getAchats() {
	return achats;
}

public void setAchats(List<offre> achats) {
	this.achats = achats;
}

public User() {
	super();
}

public User(Long idUser, UserRole role, String nom, String prenom, String email, String numtel, String adresse,String password,
		int codepostal, String ville) {
	super();
	this.idUser = idUser;
	this.role = role;
	this.nom = nom;
	this.prenom = prenom;
	this.email = email;
	this.numtel = numtel;
	this.adresse = adresse;
	this.password= password;
	this.codepostal = codepostal;
	this.ville = ville;
}


public User(UserRole role, String nom, String prenom, String email, String numtel, String adresse, String password, int codepostal,
		String ville) {
	super();
	this.role = role;
	this.nom = nom;
	this.prenom = prenom;
	this.email = email;
	this.numtel = numtel;
	this.adresse = adresse;
	this.password= password;
	this.codepostal = codepostal;
	this.ville = ville;
}


public User(UserRole role, String nom, String prenom, String email, String numtel, String adresse, String password,
		int codepostal, String ville, List<offre> achats) {
	super();
	this.role = role;
	this.nom = nom;
	this.prenom = prenom;
	this.email = email;
	this.numtel = numtel;
	this.adresse = adresse;
	this.password = password;
	this.codepostal = codepostal;
	this.ville = ville;
	this.achats = achats;
}

public Long getIdUser() {
	return idUser;
}
public void setIdUser(Long idUser) {
	this.idUser = idUser;
}
public UserRole getRole() {
	return role;
}
public void setRole(UserRole role) {
	this.role = role;
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
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getNumtel() {
	return numtel;
}
public void setNumtel(String numtel) {
	this.numtel = numtel;
}
public String getAdresse() {
	return adresse;
}
public void setAdresse(String adresse) {
	this.adresse = adresse;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password =password;
}
public int getCodepostal() {
	return codepostal;
}
public void setCodepostal(int codepostal) {
	this.codepostal = codepostal;
}
public String getVille() {
	return ville;
}
public void setVille(String ville) {
	this.ville = ville;
}

@Override
public String toString() {
	return "User [idUser=" + idUser + ", role=" + role + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email
			+ ", numtel=" + numtel + ", adresse=" + adresse + ", password=" + password + ", codepostal=" + codepostal
			+ ", ville=" + ville + ", achats=" + achats + "]";
}






}