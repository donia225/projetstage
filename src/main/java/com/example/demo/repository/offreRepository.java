package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.offre;

public interface offreRepository extends JpaRepository<offre, Long> {

	//List<offre> findByCategorieId(long idCategorie);
	List<offre> findByCategorie(String categorie);

	
}
