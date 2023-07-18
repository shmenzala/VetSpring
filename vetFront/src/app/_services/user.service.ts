import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private baseUrl = "http://localhost:8081/api/auth/login"

  requestHeader = new HttpHeaders(
    { "No-Auth": "True" }
  );
  constructor(private httpClient: HttpClient) { }

  login(loginData: any) {
    return this.httpClient.post(`${this.baseUrl}`, loginData, { headers: this.requestHeader });
  }
}
