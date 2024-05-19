package com.example.portafolio.Controlador;

import com.example.portafolio.Entidad.Educacion;
import com.example.portafolio.Servicio.EducacionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Provides a REST API for managing education-related data.
 * 
 * This controller handles CRUD operations for education entities, including
 * creating, retrieving, updating, and deleting education records.
 * 
 */
@RestController
@RequestMapping("/educacion")
@Api(value = "Controlador de Educacion", description = "Operaciones CRUD para la gestión de educacion")
public class EducacionController {

    @Autowired
    private EducacionService educacionService;

    /**
     * Creates a new education in the database.
     *
     * @param educacion The education to be created.
     * @return The created education.
     */
    @PostMapping
    @ApiOperation(value = "Crear una nueva educación", notes = "Crea una nueva educación en la base de datos")
    public Educacion crear(@RequestBody Educacion educacion) {
        return educacionService.crear(educacion);
    }

    /**
     * Retrieves a specific education record by its ID.
     *
     * @param id The ID of the education record to retrieve.
     * @return The education record with the specified ID.
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "Obtener una educación por ID", notes = "Recupera una educación específica por su ID")
    public Educacion obtener(@PathVariable Long id) {
        return educacionService.obtener(id);
    }

    /**
     * Updates an existing education in the database.
     *
     * @param educacion The education object to be updated.
     * @return The updated education object.
     */
    @PutMapping
    @ApiOperation(value = "Actualizar una educación", notes = "Actualiza una educación existente en la base de datos")
    public Educacion actualizar(@RequestBody Educacion educacion) {
        return educacionService.actualizar(educacion);
    }

    /**
     * Deletes an education record from the database.
     *
     * @param id The ID of the education record to delete.
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar una educación", notes = "Elimina una educación existente de la base de datos")
    public void eliminar(@PathVariable Long id) {
        educacionService.eliminar(id);
    }
}
