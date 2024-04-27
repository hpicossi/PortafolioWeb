package com.example.portafolio.Controlador;

import com.example.portafolio.Entidad.AcercaDeMi;
import com.example.portafolio.Servicio.AcercaDeMiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/acerca-de-mi")
@Api(value = "Acerca De Mi Controller", description = "Operaciones CRUD para la gestión de acerca-de-mi")  // Add Api annotation
public class AcercaDeMiController {

    @Autowired
    private AcercaDeMiService acercaDeMiService;

    @PostMapping
    @ApiOperation(value = "Crear información personal", notes = "Crea y guarda una nueva descripción personal")  // Add ApiOperation annotation
    public AcercaDeMi crear(@RequestBody AcercaDeMi acercaDeMi) {
        return acercaDeMiService.crear(acercaDeMi);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtener información personal", notes = "Recupera la descripción personal por su ID")  // Add ApiOperation annotation
    public AcercaDeMi obtener(@PathVariable Long id) {
        return acercaDeMiService.obtener(id);
    }

    @PutMapping
    @ApiOperation(value = "Actualizar información personal", notes = "Actualiza la descripción personal existente")  // Add ApiOperation annotation
    public AcercaDeMi actualizar(@RequestBody AcercaDeMi acercaDeMi) {
        return acercaDeMiService.actualizar(acercaDeMi);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar información personal", notes = "Elimina la descripción personal por su ID")  // Add ApiOperation annotation
    public void eliminar(@PathVariable Long id) {
        acercaDeMiService.eliminar(id);
    }
}