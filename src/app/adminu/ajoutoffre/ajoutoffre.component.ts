import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { OffreserviceService } from 'src/app/offreservice.service';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-ajoutoffre',
  templateUrl: './ajoutoffre.component.html',
  styleUrls: ['./ajoutoffre.component.css']
})
export class AjoutoffreComponent implements OnInit {
  offreForm!: FormGroup;
  offre: any = {};
  public categorie: string[] = ["Hammam, Spa et Thalasso", "Coiffure & Esthétique", "Amincissement"];

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private Offreservice: OffreserviceService
  ) {
   
  }

  ngOnInit(): void { this.offreForm = this.fb.group({
    nomcentre: ['', Validators.required],
    nomo: ['', Validators.required],
    description: ['', Validators.required],
    prix: ['', Validators.required],
    promotionDate: ['', Validators.required],
    duree: ['',Validators.required],
    image: ['',Validators.required],
    categorie:['',Validators.required]
  });}

  Ajoutoffre() {
    console.log("Méthode Ajoutoffre appelée.");
  
    if (this.offreForm.valid) {
      // Utilisez this.offreForm.value pour obtenir les données du formulaire
      console.log(this.offreForm.value);
  
      this.Offreservice.addoffre(this.offreForm.value).subscribe(
        response => {
          console.log("Offre ajoutée avec succès :", response);
          this.offreForm.reset(); // Réinitialiser le formulaire après l'ajout
  
          // Utilisez SweetAlert2 pour afficher l'alerte
          Swal.fire({
            icon: 'success',
            title: 'Offre ajoutée avec succès',
            showConfirmButton: false,
            timer: 5000
          });
        },
        error => {
          console.error("Erreur lors de l'ajout de l'offre :", error);
          if (error instanceof HttpErrorResponse) {
            console.log("Status :", error.status); // Affichez le statut de la réponse HTTP
            console.log("Message :", error.message); // Affichez le message d'erreur
          }
        }
      );
    }
  }
  

  

  onCancel() {
    this.router.navigate(['/body/offre']);
  }
}
