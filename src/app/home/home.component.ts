import { Component, OnInit } from '@angular/core';
import { OffreserviceService } from '../offreservice.service';
import { Router } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit{
  offre: any[]=[];
  selectedoffre: any = {};
  timeRemaining: any;
  constructor(private Offreservice:OffreserviceService, private route:Router ){
    

  }
  ngOnInit(): void {
    this.Offreservice.getAlloffres().subscribe(
      (response: any[]) => {
        this.offre = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  
    this.Offreservice.getCategorie().subscribe((categorie) => {
      if (categorie) {
        this.loadOffresByCategorie(categorie);
      }
    });

     // Supposons que o.promotionDate soit la date de fin de promotion
// Supposons que 'offres' soit un tableau d'offres
/* this.offre.forEach((o) => {
  o.timeRemaining = this.calculateTimeRemaining(o.promotionDate);

  // Mettez à jour le temps restant toutes les secondes
  setInterval(() => {
    o.timeRemaining = this.calculateTimeRemaining(o.promotionDate);
  }, 1000);
});
 */


  }
  loadOffresByCategorie(categorie: string) {
    this.Offreservice.getOffresByCategorie(categorie).subscribe((offres) => {
      this.offre = offres;
    });
  }
  openOfferModal(idOffre: number) {
    this.Offreservice.getoffreById(idOffre).subscribe(
    (offre:any)=>{
      this.selectedoffre=offre;
    
    },
    (error)=>{
      console.error('Error',error);
    }
    );
     

    }
gotopanier(idOffre:number){
  this.route.navigate(['/panier', idOffre]);
  
}
    // Ajoutez ces méthodes au composant HomeComponent
decrementQuantity(offre: any) {
  if (offre.quantity > 0) {
    offre.quantity--;
  }
}

incrementQuantity(offre: any) {
  offre.quantity++;
}


/*      calculateTimeRemaining(promotionDate:Date) {
      const now = new Date().getTime();
      const promotionTime = new Date(promotionDate).getTime();
      const timeDifference = promotionTime - now;
    
      const hours = Math.floor((timeDifference % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
      const minutes = Math.floor((timeDifference % (1000 * 60 * 60)) / (1000 * 60));
      const seconds = Math.floor((timeDifference % (1000 * 60)) / 1000);
    
      return { hours, minutes, seconds };
    }  */
    

}
