import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HeaderComponent } from "./components/header/header.component";
import { AcercaDeMiComponent } from "./components/acerca-de-mi/acerca-de-mi.component";
import { EducacionComponent } from "./components/educacion/educacion.component";
import { ConocimientoAptitudesComponent } from "./components/conocimiento-aptitudes/conocimiento-aptitudes.component";
import { ExperienciaComponent } from "./components/experiencia/experiencia.component";
import { ProyectosComponent } from "./components/proyectos/proyectos.component";

@Component({
    selector: 'app-root',
    standalone: true,
    templateUrl: './app.component.html',
    styleUrl: './app.component.css',
    imports: [RouterOutlet, HeaderComponent, AcercaDeMiComponent, EducacionComponent, ConocimientoAptitudesComponent, ExperienciaComponent, ProyectosComponent]
})
export class AppComponent {
  title = 'Front-Angular';
}
