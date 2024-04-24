package com.example.portafolio.Controlador;

import com.example.portafolio.Entidad.AcercaDeMi;
import com.example.portafolio.Interface.AcercaDeMiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AcercaDeMiController {

    @Autowired
    private AcercaDeMiService acercaDeMiService;

    @PostMapping("/acerca-de-mi")
    public AcercaDeMi crearAcercaDeMi(@RequestBody AcercaDeMi acercaDeMi) {
        return acercaDeMiService.guardarAcercaDeMi(acercaDeMi);
    }

    @GetMapping("/acerca-de-mi/{id}")
    public AcercaDeMi obtenerAcercaDeMiPorId(@PathVariable Long id) {
        return acercaDeMiService.obtenerAcercaDeMiPorId(id);
    }

}
