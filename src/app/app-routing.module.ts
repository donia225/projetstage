
import { HeaderComponent } from './adminu/header/header.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NavbarComponent } from './navbar/navbar.component';
import { HomeComponent } from './home/home.component';
import { FooterComponent } from './footer/footer.component';
import { LoginComponent } from './login/login.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { SignupComponent } from './signup/signup.component';
import { BodyComponent } from './adminu/body/body.component';
import { OffreComponent } from './adminu/offre/offre.component';
import { AjoutoffreComponent } from './adminu/ajoutoffre/ajoutoffre.component';
import { ModifieroffreComponent } from './adminu/modifieroffre/modifieroffre.component';
import { AdminuComponent } from './adminu/adminu.component';
import {AboutusComponent} from './aboutus/aboutus.component';
import { PanierComponent } from './panier/panier.component';



const routes: Routes = [
  {path:"navbar",component:NavbarComponent},
  {path:"home",component:HomeComponent},
  {path:"footer",component:FooterComponent},
  {path:"login",component:LoginComponent},
  {path:"sidebar",component:SidebarComponent},
  {path:"signup",component:SignupComponent},
  {path:"adminu",component:AdminuComponent},
  {path:"aboutus",component:AboutusComponent},
  {path:"panier/:idOffre", component:PanierComponent},
  
  {path:"body",component:BodyComponent,
children:[
  {path:"offre",component:OffreComponent},
  {path:"ajoutoffre",component:AjoutoffreComponent},
  {path:"modifieroffre/:idOffre",component:ModifieroffreComponent},
  

]},


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
