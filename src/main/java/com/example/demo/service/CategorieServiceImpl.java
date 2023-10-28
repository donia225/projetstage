package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.example.demo.entities.categorie;
import com.example.demo.repository.categorieRepository;
@Service
public class CategorieServiceImpl implements CategorieService {
	
@Autowired
categorieRepository cr;
	@Override
	
	public categorie saveCategorie(categorie c) {
		return cr.save(c);
	}

	@Override
	public categorie updatecategorie(categorie c) {
		return cr.save(c);
	}

	@Override
	public void deletecategorie(categorie c) {
		cr.delete(c);
		
	}

	@Override
	public void deletecategorieById(Long id) {
		cr.deleteById(id);
		
	}

	@Override
	public categorie getcategorie(Long id) {
		return cr.findById(id).get();
	}

	@Override
	public List<categorie> getAllcategories() {
		return cr.findAll();
	}

}
