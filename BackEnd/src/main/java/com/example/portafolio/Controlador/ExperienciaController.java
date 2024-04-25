package com.example.portafolio.Controlador;

import com.example.portafolio.Entidad.Experiencia;
import com.example.portafolio.Servicio.ExperienciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/experiencia")
public class ExperienciaController {

    @Autowired
    private ExperienciaService experienciaService;

    @PostMapping
    public Experiencia crear(@RequestBody Experiencia experiencia) {
        return experienciaService.crear(experiencia);
    }

    @GetMapping("/{id}")
    public Experiencia obtener(@PathVariable Long id) {
        return experienciaService.obtener(id);
    }

    @PutMapping
    public Experiencia actualizar(@RequestBody Experiencia experiencia) {
        return experienciaService.actualizar(experiencia);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        experienciaService.eliminar(id);
    }
}
