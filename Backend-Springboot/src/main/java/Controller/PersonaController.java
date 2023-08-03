package Controller;

import Entity.Persona;
import Interface.IPersonaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proyectos")
public class PersonaController {

    final
    IPersonaService iPersonaService;

    public PersonaController(IPersonaService iPersonaService) {
        this.iPersonaService = iPersonaService;
    }

    @GetMapping("/traer")
    public List<Persona> getPersona(){
        return iPersonaService.getPersona();
    }

    @PutMapping("/editar/{id}")
    public Persona editarPersona(@PathVariable Long id,
                                 @RequestParam("nombre") String nuevoNombre,
                                 @RequestParam("apellido") String nuevoApellido,
                                 @RequestParam("img") String nuevoImg){

        Persona persona = iPersonaService.findPersona(id);

        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(nuevoImg);

        iPersonaService.savePersona(persona);
        return persona;
    }

    @PostMapping("/crear")
    public String createPersona(@RequestBody Persona persona){
        iPersonaService.savePersona(persona);
        return "La persona fue creada correctamente";
    }

    @DeleteMapping("/borrar/{id}")
    public String borrarPersona(@PathVariable Long id){
        iPersonaService.deletePersona(id);
        return "La persona fue borrada correctamente";
    }
}
