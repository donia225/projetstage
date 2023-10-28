import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private baseUrl = 'http://localhost:8082/user';
 
  constructor(private http: HttpClient) { }

// UserService
authenticateUser(data:any): Observable<any> {
  return this.http.post(`${this.baseUrl}/login`, data);
}

}
