package com.example.demo.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.offre;
import com.example.demo.repository.offreRepository;

@Service
public class OffreServiceImpl implements OffreService {
   @Autowired
    offreRepository or;

	@Override
	public offre saveOffre(offre o) {
		return or.save(o);
	}

	@Override
	public offre updateOffre(offre o) {
		return or.save(o);
	}

	@Override
	public void deleteOffre(offre o) {
		or.delete(o);
		
	}

	@Override
	public void deleteOffreById(Long id) {
		or.deleteById(id);
		
	}

	@Override
	public offre getOffre(Long id) {
		return or.findById(id).get();
	}

	@Override
	public List<offre> getAlloffres() {
		return or.findAll();
	}
	public List<offre> getOffresByCategorie(String categorie) {
	    // Implémentez la logique pour récupérer les offres par catégorie depuis votre base de données
	    return or.findByCategorie(categorie); // Supposons que vous avez un repository appelé "offreRepository"
	}

	/*@Override
    public List<offre> getOffresByCategory(Long idCategorie) {
        // Implémentez la logique pour récupérer les offres par catégorie en utilisant categoryId
        // Vous pouvez appeler votre repository pour effectuer cette opération
        return or.findByCategorieId(idCategorie);
    }*/

}
