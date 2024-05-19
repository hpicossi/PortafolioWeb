package com.example.portafolio.Controlador;

import com.example.portafolio.Entidad.AcercaDeMi;
import com.example.portafolio.Servicio.AcercaDeMiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
     * Provides REST API endpoints for managing personal information (About Me) in
     * the application.
     * 
     * The AcercaDeMiController class handles the creation, retrieval, update, and
     * deletion of personal information (About Me) data.
     * It uses the AcercaDeMiService to interact with the underlying data storage.
     * 
     */
@RestController
@RequestMapping("/acerca-de-mi")
@Api(value = "Acerca De Mi Controller", description = "Operaciones CRUD para la gestión de acerca-de-mi")  // Add Api annotation
public class AcercaDeMiController {

    
    @Autowired
    private AcercaDeMiService acercaDeMiService;

    /**
     * Creates and saves a new personal description.
     *
     * @param acercaDeMi the personal description to create
     * @return the created personal description
     */
    @PostMapping
    @ApiOperation(value = "Crear información personal", notes = "Crea y guarda una nueva descripción personal")
    public AcercaDeMi crear(@RequestBody AcercaDeMi acercaDeMi) {
        return acercaDeMiService.crear(acercaDeMi);
    }

    /**
     * Retrieves the personal description by its ID.
     *
     * @param id the ID of the personal description to retrieve
     * @return the personal description
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "Obtener información personal", notes = "Recupera la descripción personal por su ID")
    public AcercaDeMi obtener(@PathVariable Long id) {
        return acercaDeMiService.obtener(id);
    }

    /**
     * Updates the existing personal description.
     *
     * @param acercaDeMi the updated personal description
     * @return the updated personal description
     */
    @PutMapping
    @ApiOperation(value = "Actualizar información personal", notes = "Actualiza la descripción personal existente")
    public AcercaDeMi actualizar(@RequestBody AcercaDeMi acercaDeMi) {
        return acercaDeMiService.actualizar(acercaDeMi);
    }

    /**
     * Deletes the personal description by its ID.
     *
     * @param id The ID of the personal description to delete.
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar información personal", notes = "Elimina la descripción personal por su ID")
    public void eliminar(@PathVariable Long id) {
        acercaDeMiService.eliminar(id);
    }
}