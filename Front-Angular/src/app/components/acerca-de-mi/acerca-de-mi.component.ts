import { Component, OnInit, inject } from '@angular/core';
import { PersonaService } from '../../service/persona.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-acerca-de-mi',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './acerca-de-mi.component.html',
  styleUrl: './acerca-de-mi.component.css'
})
export class AcercaDeMiComponent {


  private readonly productsSvc = inject(PersonaService);
  products? = this.productsSvc.getPersona();
  // persona: persona = new persona("","","");

  // constructor(public personaService: PersonaService){}

  // ngOnInit(): void {
  //   this.personaService.getPersona().subscribe(
  //     (data) => {
  //       this.persona = data;
  //     },
  //     (error) => {
  //       console.error('Error al obtener la persona:', error);
  //       // Aquí puedes agregar lógica para manejar el error, como mostrar un mensaje de error al usuario
  //     }
  //   );
  // }

}
