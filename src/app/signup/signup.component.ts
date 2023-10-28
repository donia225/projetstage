import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ValidatorFn, AbstractControl } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit{
  forminput!:FormGroup
constructor(private fb: FormBuilder, private route:Router){

}
ngOnInit(): void {
  this.forminput=this.fb.group({
    "firstname":["", [Validators.required]],
    "lastname":["", Validators.required],
    "email":["", [Validators.required, Validators.email]],
    "phonenumber":["", Validators.required],
    "password":["", Validators.required],
  }

  )
 

}


onsubmit(){
  //console.log("test submit !!!")
  //console.log(this.forminput.controls)

  console.log(this.forminput.status)

if(this.forminput.valid) {
  this.route.navigate(["/"]);

  
}
}
}