import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { offre } from './Models/offre';


@Injectable({
  providedIn: 'root'
})
export class OffreserviceService {
  readonly url = 'http://localhost:8082/offre';
  readonly urlget = '/getAll';
  readonly getu='/get';
  readonly addu = '/add';
  readonly deletee='/delete';
  
  private categorieSubject = new BehaviorSubject<string>('');
  constructor(private httpClient: HttpClient) { }

  public getAlloffres(): Observable<any> {
    console.log("Calling getAlloffres()...");
   
    return this.httpClient.get(`${this.url}${this.urlget}`);
  }
  
  public getoffreById(idOffre:number):Observable<any>{
    return this.httpClient.get(`${this.url}${this.getu}/${idOffre}`);
  }

  public addoffre(offre: any): Observable<any> {
    return this.httpClient.post(`${this.url}${this.addu}`, offre);
  }
  
  public deleteoffre(idOffre:number):Observable<any>{
    return this.httpClient.delete(`${this.url}${this.deletee}/${idOffre}`);
  }
  public updateoffre(idOffre: number, offre:any): Observable<any> {
    return this.httpClient.put(`${this.url}/${idOffre}`, offre);
  }
  public getOffresByCategorie(categorie: string): Observable<any> {
    const params = new HttpParams().set('categorie', categorie);
    return this.httpClient.get(`${this.url}/offresByCategorie`, { params });
  }


  // Méthode pour définir la catégorie sélectionnée
  setCategorie(categorie: string) {
    this.categorieSubject.next(categorie);
  }

  // Méthode pour obtenir la catégorie sélectionnée en tant qu'observable
  getCategorie(): Observable<string> {
    return this.categorieSubject.asObservable();
  }
}
