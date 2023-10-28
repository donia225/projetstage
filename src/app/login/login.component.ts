import { Component, OnInit } from '@angular/core';
import {FormGroup, FormBuilder, Validators} from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  forminput!:FormGroup
  //eli na3mlou f dekhel l constructeur hia injection des dépendances ma3netha ki nest7a9 un objet mech mawjoud f projet mte3i jebtou men angular
  //ninjectih pour éviter l'instanciation lena au lieu de faire fb=new objet
  formData:any;
  
constructor(private fb: FormBuilder, private route:Router,private userservice:UserService)
{

}
ngOnInit(): void {
    this.forminput=this.fb.group({
      "email":["", [Validators.required, Validators.email]],
      "password":["", Validators.required]
    }

    )
}
  onsubmit():void{
console.log("test submit !!!")
//console.log(this.forminput)
console.log(this.forminput.controls)
//console.log(this.forminput.controls["email"].errors)
console.log(this.forminput.status)

/* if(this.forminput.valid) {
  this.route.navigate(['/']);
  //this.route.navigate(['/sidebar']);
} */
 // Appel de la méthode d'authentification
 if(this.forminput.valid){
  const formData=this.forminput.value;
 this.userservice.authenticateUser(formData).subscribe(
   (response:any) => {
// Ajoutez cette ligne pour afficher la réponse du service dans la console
       if (response ) {
         // Authentification réussie pour une cliente
         // Redirigez l'utilisateur ou effectuez d'autres actions nécessaires
         this.route.navigate(['/home']); // Redirigez vers la page d'accueil, ajustez selon vos besoins
       } else {
         // Authentification échouée ou rôle incorrect
         // Affichez un message d'erreur à l'utilisateur, par exemple :
         console.log('Authentification échouée ou rôle incorrect');
         // Ou affichez un message d'erreur dans un élément HTML, par exemple :
         // this.errorMessage = 'Authentification échouée ou rôle incorrect';
       }
     
    },
   (error) => {
     // Gérez les erreurs en cas de problème de connexion, par exemple :
     console.error('Erreur de connexion :', error);
     // Ou affichez un message d'erreur dans un élément HTML, par exemple :
     // this.errorMessage = 'Erreur de connexion : ' + error.message;
   }
 );
  }
}
  

  authenticateUser() {
   
  }
  
  
  
  
}
