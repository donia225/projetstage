package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.categorie;
import com.example.demo.repository.categorieRepository;
import com.example.demo.service.CategorieService;



@CrossOrigin("*")
@RestController
@RequestMapping("/categorie")
public class CategorieController {
	@Autowired
	private CategorieService cs;
	@Autowired
    private categorieRepository categorieRepository;
	
	@GetMapping("/getAll")
	public List<categorie> getAllcategories() {
		return cs.getAllcategories();
}
	@GetMapping("/get/{id}")
	public categorie findcategorieById(@PathVariable Long id) {
		return cs.getcategorie(id);
	}
	
	@PostMapping("/add")
	public categorie addcategorie(@RequestBody categorie c) {
		return cs.saveCategorie(c);
	}

	 @PutMapping("/{id}")
	    public ResponseEntity<categorie> updateCategorie(@PathVariable Long id, @RequestBody categorie c) {
	        categorie categorie = cs.getcategorie(id);
	        if (categorie != null) {
	            categorie.setNomC(c.getNomC());
	          
	            categorie categorieupdate = categorieRepository.save(categorie);

	            return ResponseEntity.ok(categorieupdate);
	        } else {
	            // L'offre n'existe pas, renvoyez une réponse 404 (Not Found)
	            return ResponseEntity.notFound().build();
	        }
	    }
	@DeleteMapping("/delete/{id}")
	public void deletecategorie(@PathVariable Long id) {
		 cs.deletecategorieById(id);
	}
	
	
}
