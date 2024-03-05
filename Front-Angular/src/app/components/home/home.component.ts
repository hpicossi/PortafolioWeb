import { Component } from '@angular/core';
import { HeaderComponent } from "../header/header.component";
import { AcercaDeMiComponent } from "../acerca-de-mi/acerca-de-mi.component";
import { EducacionComponent } from "../educacion/educacion.component";
import { ConocimientoAptitudesComponent } from "../conocimiento-aptitudes/conocimiento-aptitudes.component";
import { ExperienciaComponent } from "../experiencia/experiencia.component";
import { ProyectosComponent } from "../proyectos/proyectos.component";

@Component({
    selector: 'app-home',
    standalone: true,
    templateUrl: './home.component.html',
    styleUrl: './home.component.css',
    imports: [HeaderComponent, AcercaDeMiComponent, EducacionComponent, ConocimientoAptitudesComponent, ExperienciaComponent, ProyectosComponent]
})
export class HomeComponent {

}
