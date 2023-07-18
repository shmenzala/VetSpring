import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { UserService } from '../_services/user.service';
import { UserAuthService } from '../_services/user-auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private userService: UserService, private userAuthService: UserAuthService, private router: Router) { }

  ngOnInit(): void {
  }

  login(loginForm: NgForm) {
    this.userService.login(loginForm.value).subscribe((data: any) => {
      console.log(data.tokenDeAcceso);
      console.log(data.tipoDeToken);
      
      // let jwtData = data.tokenDeAcceso.split('.')[1];
      // let decodedJwtJsonData = window.atob(jwtData);
      // let decodedJwtData = JSON.parse(decodedJwtJsonData);
      // console.log(jwtData);
      // console.log(decodedJwtJsonData);
      // console.log(decodedJwtData);

      this.userAuthService.setToken(data.tokenDeAcceso);
      //Si se logueó, vamos a la ruta /home
      this.router.navigate(['/home']);

    }, (error) => alert("Sorry Please enter correct username and password..."))


  }

}
