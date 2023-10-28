import { HttpErrorResponse } from '@angular/common/http';
import { Component,OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { OffreserviceService } from 'src/app/offreservice.service';


@Component({
  selector: 'app-modifieroffre',
  templateUrl: './modifieroffre.component.html',
  styleUrls: ['./modifieroffre.component.css']
})
export class ModifieroffreComponent implements OnInit  {
  offre: any = {};
  offreForm!: FormGroup;
  idOffre!:number;
  public categorie: string[] = ["Hammam, Spa et Thalasso", "Coiffure & Esthétique", "Amincissement"];
constructor(private activateRoute:ActivatedRoute,private fb: FormBuilder,private offreservice:OffreserviceService,private router: Router){

}

updateoffre(){
  if(this.offreForm.valid) {
  const offre = this.offre;
offre.nomcentre=this.offreForm.controls['nomcentre'].value
offre.nomo=this.offreForm.controls['nomo'].value
offre.description=this.offreForm.controls['description'].value
offre.prix=this.offreForm.controls['prix'].value
offre.promotionDate=this.offreForm.controls['promotionDate'].value
offre.duree=this.offreForm.controls['duree'].value
offre.imageo=this.offreForm.controls['imageo'].value
offre.categorie=this.offreForm.controls['categorie'].value

this.offreservice.updateoffre(this.idOffre,offre).subscribe(
  (o)=>{
    console.log(o.nomo)
    alert("Offre modifiée avec succès");
  }

)
  }
}
onCancel() {
  this.router.navigate(['/body/offre']);
}



ngOnInit(): void {
  this.activateRoute.params.subscribe(
    (param)=>{
     this.idOffre=param['idOffre']
    }
  )
  this.offreForm = this.fb.group({
    nomcentre: ['', Validators.required],
    nomo: ['', Validators.required],
    description: ['', Validators.required],
    prix: ['', Validators.required],
    promotionDate: ['', Validators.required],
    duree: ['',Validators.required],
    imageo: ['',Validators.required],
    categorie:['',Validators.required]
  });


  
  this.offreservice.getoffreById(this.idOffre).subscribe(
    (offre:any)=>{
      this.offreForm.controls['nomcentre'].setValue(offre.nomcentre)
      this.offreForm.controls['nomo'].setValue(offre.nomo)
      this.offreForm.controls['description'].setValue(offre.description)
      this.offreForm.controls['prix'].setValue(offre.prix)
      this.offreForm.controls['promotionDate'].setValue(offre.promotionDate)
      this.offreForm.controls['duree'].setValue(offre.duree)
      this.offreForm.controls['imageo'].setValue(offre.imageo)
      this.offreForm.controls['categorie'].setValue(offre.categorie)
    }
  )

}



}
