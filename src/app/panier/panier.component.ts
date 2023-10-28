import { offre } from './../Models/offre';
import { Component, OnInit } from '@angular/core';
import { OffreserviceService } from '../offreservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-panier',
  templateUrl: './panier.component.html',
  styleUrls: ['./panier.component.css']
})
export class PanierComponent implements OnInit {
 
  offre: any[] = [ { nomo: 'Epilation définitive', prix: 300, quantite: 1}
   
  ];


  constructor(private Offreservice:OffreserviceService, private route:Router ) {

  }
  calculateTotal(): number {
    let total = 0;
    for (const o of this.offre) {
      total += o.prix * o.quantite;
    }
    return total;
  }
  ajouterpanier(idOffre: number) {
    this.Offreservice.getoffreById(idOffre).subscribe(
      (offre: any) => {
        const copieOffre = { ...offre };  // Copie de l'offre
        this.offre.push(copieOffre);  // Ajout de la copie à la liste
      },
      (error) => {
        console.error('Erreur lors de l\'ajout au panier :', error);
      }
    );
  }
  
  ngOnInit(): void {
    
  }
}
