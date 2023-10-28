package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.categorie;


public interface CategorieService {
	categorie saveCategorie(categorie c);
	categorie updatecategorie(categorie c);
	void deletecategorie(categorie c);
	void deletecategorieById(Long id);
	categorie getcategorie(Long id);
	List<categorie> getAllcategories();
}
