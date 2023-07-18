import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserAuthService {

  constructor() { }

  setToken(jwtToken: string){
    localStorage.setItem('tokenDeAcceso', jwtToken);
  }

  getToken(): string{
    return localStorage.getItem('tokenDeAcceso')!;
  }

  // setRoles(roles:[]){
  //   localStorage.setItem('roles', JSON.stringify(roles));
  // }

  getRoles(): string[] {
    //return JSON.parse(localStorage.getItem('roles') || '[]');
    const token = this.getToken();
    const payload = token.split('.')[1];
    const payloadDecoded = atob(payload);
    const val = JSON.parse(payloadDecoded);

    const roles = val.roles;

    return roles;
  }

  clear(){
    localStorage.clear()
  }

  isLoggedIn(){
    return this.getToken();
  }

}
