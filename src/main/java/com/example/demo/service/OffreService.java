package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.offre;

public interface OffreService {
offre saveOffre(offre o);
offre updateOffre(offre o);
void deleteOffre(offre o);
void deleteOffreById(Long id);
offre getOffre(Long id);
List<offre> getAlloffres();
public List<offre> getOffresByCategorie(String categorie);
//public List<offre> getOffresByCategory(Long idCategorie);


}

