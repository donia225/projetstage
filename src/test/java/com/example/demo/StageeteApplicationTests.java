package com.example.demo;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entities.categorie;
import com.example.demo.entities.offre;
import com.example.demo.repository.categorieRepository;
import com.example.demo.repository.offreRepository;

@SpringBootTest
class StageeteApplicationTests {

	@Autowired
	private categorieRepository cr;
	
	@Autowired
	private offreRepository or;
	
	@Test
	public void testCreatecategorie() {
		categorie categorie=new categorie("spa");
		cr.save(categorie);
	}
	
	/*@Test
	public void testCreateOffre() {
	    String promotionDateStr = "2023-08-28";
	    LocalDate promotionDate = LocalDate.parse(promotionDateStr); // Convertir la chaîne en LocalDate
	    
	    Integer duree = 5; // Durée de la promotion en jours

	    offre offre = new offre("Soin de visage", "Soin visage", 30.000, promotionDate, duree, "image_url_here");
	    System.out.println(offre.getNomo());
	    System.out.println(offre.getDescription());
	    System.out.println(offre.getPrix());
	    System.out.println(offre.getPromotionDate());
	    System.out.println(offre.getDuree());
	    System.out.println(offre.getImageo());
	    or.save(offre);
	}*/


	@Test
	public void testfindoffre() {
		offre o=or.findById(1L).get();
		System.out.println(o);
	}
	
	@Test
	public void testUpdateOffre() {
		offre o=or.findById(1L).get();
		o.setPrix(16.000);
		or.save(o);
		System.out.println(o);
	}
	
	@Test
	public void testDeleteoffre() {
		or.deleteById(1L);
	}
	
	@Test
	public void testfindAlloffres() {
		List<offre> offres=or.findAll();
		for(offre o:offres) {
			System.out.println(o);
		}	
	}
	
	
	
	
}
