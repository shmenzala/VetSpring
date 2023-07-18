import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { CitconsultComponent } from './citconsult/citconsult.component';
import { MascotasComponent } from './mascotas/mascotas.component';
import { PersonasComponent } from './personas/personas.component';
import { ServiciosComponent } from './servicios/servicios.component';
import { VacunasComponent } from './vacunas/vacunas.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';

const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  {
    path: 'home', component: HomeComponent,
    children: [
      { path: 'citconsult', component: CitconsultComponent },
      { path: 'mascotas', component: MascotasComponent },
      { path: 'personas', component: PersonasComponent },
      { path: 'servicios', component: ServiciosComponent },
      { path: 'vacunas', component: VacunasComponent }
    ]
  },
  { path: 'login', component: LoginComponent },
  // { path: 'citconsult', component: CitconsultComponent },
  // { path: 'mascotas', component: MascotasComponent },
  // { path: 'personas', component: PersonasComponent },
  // { path: 'servicios', component: ServiciosComponent },
  // { path: 'vacunas', component: VacunasComponent },
  { path: 'forbidden', component: ForbiddenComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
