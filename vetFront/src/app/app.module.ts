import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';
import { HeaderComponent } from './header/header.component';
import { CitconsultComponent } from './citconsult/citconsult.component';
import { MascotasComponent } from './mascotas/mascotas.component';
import { PersonasComponent } from './personas/personas.component';
import { ServiciosComponent } from './servicios/servicios.component';
import { VacunasComponent } from './vacunas/vacunas.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    ForbiddenComponent,
    HeaderComponent,
    CitconsultComponent,
    MascotasComponent,
    PersonasComponent,
    ServiciosComponent,
    VacunasComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    RouterModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
