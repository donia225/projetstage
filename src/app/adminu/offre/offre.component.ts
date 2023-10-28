import { OffreserviceService } from 'src/app/offreservice.service';
import { Component, OnInit } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router';


@Component({
  selector: 'app-offre',
  templateUrl: './offre.component.html',
  styleUrls: ['./offre.component.css']
})
export class OffreComponent implements OnInit{
  offre: any[]=[];
  selectedoffre: any = {};
  offreToDeleteId: number | null = null;
  isBodyPage = true; 


constructor(private Offreservice:OffreserviceService,private route:Router){
console.log('isBodyPage:',this.isBodyPage)
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
confirmerSuppression() {
  if (this.offreToDeleteId !== null) {
    this.Offreservice.deleteoffre(this.offreToDeleteId).subscribe(
      () => {
        // Filtrer la liste pour exclure l'offre supprimée
        this.offre = this.offre.filter(o => o.idOffre !== this.offreToDeleteId);
      },
      (error) => {
        console.error('Error', error);
      }
    );
  }
  this.offreToDeleteId = null; // Réinitialiser l'ID
}


goToModifierOffrePage(idOffre: number) {
  this.route.navigate(['/body/modifieroffre', idOffre]);
}

ngOnInit(): void {
  this.Offreservice.getAlloffres().subscribe((response:any[])=>{
    this.offre=response;
    
  },
  (error:HttpErrorResponse)=>{
    alert(error.message);
  }
  );
    
}
}
