import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Observable } from 'rxjs';
import { persona } from '../model/persona.model';

@Injectable({
  providedIn: 'root'
})
export class PersonaService {

  // URL = 'http://localhost:8080/personas/'

  // constructor(private http: HttpClient) { }

  // public getPersona(): Observable<persona>{
  //   return this.http.get<persona>(this.URL + 'traer/perfil');
  // }

  private readonly _http = inject(HttpClient);

  getPersona(): Observable<any>{
    return this._http.get('https://fakestoreapi.com/products');
  }

}
