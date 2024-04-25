package com.example.portafolio.Controlador;

import com.example.portafolio.Entidad.AcercaDeMi;
import com.example.portafolio.Servicio.AcercaDeMiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/acerca-de-mi")
public class AcercaDeMiController {

    @Autowired
    private AcercaDeMiService acercaDeMiService;

    @PostMapping
    public AcercaDeMi crear(@RequestBody AcercaDeMi acercaDeMi) {
        return acercaDeMiService.crear(acercaDeMi);
    }

    @GetMapping("/{id}")
    public AcercaDeMi obtener(@PathVariable Long id) {
        return acercaDeMiService.obtener(id);
    }

    @PutMapping
    public AcercaDeMi actualizar(@RequestBody AcercaDeMi acercaDeMi) {
        return acercaDeMiService.actualizar(acercaDeMi);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        acercaDeMiService.eliminar(id);
    }
}