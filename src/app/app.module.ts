import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { NavbarComponent } from './navbar/navbar.component';
import { FooterComponent } from './footer/footer.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { SignupComponent } from './signup/signup.component';
import { HttpClientModule } from '@angular/common/http';
import { AsidebarComponent } from './adminu/asidebar/asidebar.component';
import { HeaderComponent } from './adminu/header/header.component';
import { BodyComponent } from './adminu/body/body.component';
import { OffreComponent } from './adminu/offre/offre.component';
import { AjoutoffreComponent } from './adminu/ajoutoffre/ajoutoffre.component';
import { ModifieroffreComponent } from './adminu/modifieroffre/modifieroffre.component';
import { AdminuComponent } from './adminu/adminu.component';
import { AboutusComponent } from './aboutus/aboutus.component';
import { PanierComponent } from './panier/panier.component';



@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavbarComponent,
    FooterComponent,
    LoginComponent,
    SidebarComponent,
    SignupComponent,
    OffreComponent,
    AsidebarComponent,
    HeaderComponent,
    BodyComponent,
    AjoutoffreComponent,
    ModifieroffreComponent,
    AdminuComponent,
    AboutusComponent,
    PanierComponent,
  
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
