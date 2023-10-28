import { Component, Input, OnInit } from '@angular/core';
import { RouterModule } from '@angular/router';
import { Routes } from '@angular/router';
import { OffreserviceService } from '../offreservice.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
 
constructor(private offreservice:OffreserviceService) {

}
loadOffresByCategorie(categorie: string) {
  // Utilisez le service OffreService pour définir la catégorie sélectionnée
  console.log(`Catégorie sélectionnée : ${categorie}`);
  this.offreservice.setCategorie(categorie);
}

ngOnInit(): void {
    
}
}
