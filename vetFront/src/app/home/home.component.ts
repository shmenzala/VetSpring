import { Component, OnInit } from '@angular/core';
import { UserAuthService } from '../_services/user-auth.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private userAuthService: UserAuthService) { }

  ngOnInit(): void {
  }

  isAdmin(): boolean {
    const userRole: string[] = this.userAuthService.getRoles()

    if (userRole.includes("ROLE_ADMIN")) {
      return true
    } else {
      return false
    }
    
  }

}
