package com.example.portafolio.Controlador;

import com.example.portafolio.Entidad.Experiencia;
import com.example.portafolio.Servicio.ExperienciaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for managing experience-related operations.
 * Provides CRUD (Create, Read, Update, Delete) operations for managing
 * experiences.
 */
@RestController
@RequestMapping("/experiencia")
@Api(value = "Controlador de Experiencia", description = "Operaciones CRUD para la gestión de experiencia")
public class ExperienciaController {

    @Autowired
    private ExperienciaService experienciaService;

    /**
     * Creates a new experience in the database.
     *
     * @param experiencia The experience to be created.
     * @return The created experience.
     */
    @PostMapping
    @ApiOperation(value = "Crear una nueva experiencia", notes = "Crea una nueva experiencia en la base de datos")
    public Experiencia crear(@RequestBody Experiencia experiencia) {
        return experienciaService.crear(experiencia);
    }

    /**
     * Retrieves a specific experience by its ID.
     *
     * @param id The ID of the experience to retrieve.
     * @return The experience with the specified ID.
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "Obtener una experiencia por ID", notes = "Recupera una experiencia específica por su ID")
    public Experiencia obtener(@PathVariable Long id) {
        return experienciaService.obtener(id);
    }

    /**
     * Updates an existing experience in the database.
     *
     * @param experiencia The experience object to be updated.
     * @return The updated experience object.
     */
    @PutMapping
    @ApiOperation(value = "Actualizar una experiencia", notes = "Actualiza una experiencia existente en la base de datos")
    public Experiencia actualizar(@RequestBody Experiencia experiencia) {
        return experienciaService.actualizar(experiencia);
    }

    /**
     * Deletes an existing experience from the database.
     *
     * @param id The ID of the experience to be deleted.
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar una experiencia", notes = "Elimina una experiencia existente de la base de datos")
    public void eliminar(@PathVariable Long id) {
        experienciaService.eliminar(id);
    }
}
