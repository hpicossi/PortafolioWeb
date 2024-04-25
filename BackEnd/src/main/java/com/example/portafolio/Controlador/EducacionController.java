package com.example.portafolio.Controlador;

import com.example.portafolio.Entidad.Educacion;
import com.example.portafolio.Servicio.EducacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/educacion")
public class EducacionController {

    @Autowired
    private EducacionService educacionService;

    @PostMapping
    public Educacion crear(@RequestBody Educacion educacion) {
        return educacionService.crear(educacion);
    }

    @GetMapping("/{id}")
    public Educacion obtener(@PathVariable Long id) {
        return educacionService.obtener(id);
    }

    @PutMapping
    public Educacion actualizar(@RequestBody Educacion educacion) {
        return educacionService.actualizar(educacion);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        educacionService.eliminar(id);
    }
}
