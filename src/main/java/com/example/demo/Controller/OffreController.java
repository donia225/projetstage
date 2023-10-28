package com.example.demo.Controller;


import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.categorie;
import com.example.demo.entities.offre;
import com.example.demo.service.OffreService;
import com.example.demo.repository.categorieRepository;
import com.example.demo.repository.offreRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/offre")

public class OffreController {
	@Autowired
	private OffreService os;
	@Autowired
    private offreRepository offreRepository;
	@Autowired
	private categorieRepository cr;
	
	@GetMapping("/getAll")
	public List<offre> getAlloffres() {
		return os.getAlloffres();
		
}
	@GetMapping("/get/{id}")
	public offre findoffreById(@PathVariable Long id) {
		return os.getOffre(id);
	}
	@GetMapping("/offresByCategorie")
	public ResponseEntity<List<offre>> getOffresByCategorie(@RequestParam("categorie") String categorie) {
	    List<offre> offres = os.getOffresByCategorie(categorie); // Vous devrez implémenter cette méthode dans votre service
	    return new ResponseEntity<>(offres, HttpStatus.OK);
	}

	
	/*@GetMapping("/getByCategory/{idCategorie}")
	public List<offre> getOffresByCategory(@PathVariable Long idCategorie) {
	 
	    return os.getOffresByCategory(idCategorie);
	}*/


	@PostMapping("/add")
	public ResponseEntity<String> addOffre(@RequestBody offre o) {
	    // Vérifiez si la date de promotion est fournie par le client
	    if (o.getPromotionDate() == null) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Promotion date is required\"}");
	    }
	    
	    try {
	        // Ajoutez l'offre à la base de données
	        os.saveOffre(o);
	        return ResponseEntity.ok("{\"message\": \"Offre added successfully\"}");
	    } catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"message\": \"Error adding offre\"}");
	    }
	}

	 @PutMapping("/{id}")
 ResponseEntity<offre> updateOffre(@PathVariable Long id, @RequestBody offre offre) {

	         offre existingOffre = os.getOffre(id);
	     
	         if (existingOffre != null) {
	      
	        	 existingOffre.setNomcentre(offre.getNomcentre());
	             existingOffre.setNomo(offre.getNomo());
	             existingOffre.setDescription(offre.getDescription());
	             existingOffre.setPrix(offre.getPrix());
	             existingOffre.setAncienprix(offre.getAncienprix());
	             existingOffre.setPromotionDate(offre.getPromotionDate());
	             existingOffre.setDuree(offre.getDuree());
	             existingOffre.setImageo(offre.getImageo());
	             existingOffre.setCategorie(offre.getCategorie());  existingOffre.setDuree(offre.getDuree());
	             existingOffre.setQuantite(offre.getQuantite());
	             
	             // Enregistrez l'offre mise à jour dans la base de données
	             offre updatedExistingOffre = offreRepository.save(existingOffre);

	             return ResponseEntity.ok(updatedExistingOffre);
	         } else {
	             // L'offre n'existe pas, renvoyez une réponse 404 (Not Found)
	             return ResponseEntity.notFound().build();
	         }
	   
	 }


	@DeleteMapping("/delete/{id}")
	public void deleteoffre(@PathVariable Long id) {
		 os.deleteOffreById(id);
	}
	
	
	
	
}
