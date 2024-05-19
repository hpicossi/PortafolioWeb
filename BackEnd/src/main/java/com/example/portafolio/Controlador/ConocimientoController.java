package com.example.portafolio.Controlador;

import com.example.portafolio.Entidad.Conocimiento;
import com.example.portafolio.Servicio.ConocimientoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * Provides a REST API for managing knowledge entities.
 * 
 * This controller class handles the CRUD operations for knowledge entities,
 * including retrieving all knowledge entities, getting a specific knowledge
 * entity by ID, creating a new knowledge entity, deleting a knowledge entity,
 * and uploading and retrieving images associated with knowledge entities.
 * 
 */
@RestController
@RequestMapping("/conocimiento")
@Api(value = "Controlador de Conocimientos", description = "Operaciones CRUD para la gestión de conocimientos")
public class ConocimientoController {

    @Autowired
    private ConocimientoService conocimientoService;

    /**
     * Retrieves a list of all existing knowledge items.
     *
     * @return a list of all {@link Conocimiento} instances
     */
    @GetMapping
    @ApiOperation(value = "Obtener todos los conocimientos", notes = "Recupera una lista de todos los conocimientos existentes")
    public List<Conocimiento> getAllConocimientos() {
        return conocimientoService.getAllConocimientos();
    }

    /**
     * Retrieves a specific knowledge item by its ID.
     *
     * @param id The ID of the knowledge item to retrieve.
     * @return The knowledge item with the specified ID.
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "Obtener un conocimiento por ID", notes = "Recupera un conocimiento específico por su ID")
    public Conocimiento getConocimientoById(@PathVariable Long id) {
        return conocimientoService.getConocimientoById(id);
    }

    /**
     * Saves a new knowledge item in the database.
     *
     * @param conocimiento The knowledge item to be saved.
     * @return The saved knowledge item.
     */
    @PostMapping
    @ApiOperation(value = "Crear un nuevo conocimiento", notes = "Crea un nuevo conocimiento en la base de datos")
    public Conocimiento saveConocimiento(@RequestBody Conocimiento conocimiento) {
        return conocimientoService.saveConocimiento(conocimiento);
    }

    /**
     * Deletes an existing knowledge item from the database.
     *
     * @param id The ID of the knowledge item to delete.
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar un conocimiento", notes = "Elimina un conocimiento existente de la base de datos")
    public void deleteConocimiento(@PathVariable Long id) {
        conocimientoService.deleteConocimiento(id);
    }

    /**
     * Saves an image associated with a knowledge item.
     *
     * @param id     The ID of the knowledge item to associate the image with.
     * @param imagen The image file to be saved.
     * @throws IllegalArgumentException If the uploaded file is not a valid image.
     * @throws RuntimeException         If there is an error processing the image.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public void saveImagen(@PathVariable Long id, @RequestParam("imagen") MultipartFile imagen) {
        if (!imagen.getContentType().startsWith("image/")) {
            throw new IllegalArgumentException("El archivo cargado no es una imagen válida");
        }

        try {
            byte[] bytes = imagen.getBytes();
            conocimientoService.saveImagen(id, bytes);
        } catch (IOException e) {
            throw new RuntimeException("Error al procesar la imagen", e);
        }
    }

    /**
     * Retrieves the image associated with a given knowledge item.
     *
     * @param id The ID of the knowledge item to retrieve the image for.
     * @return A ResponseEntity containing the image data, or a 404 Not Found
     *         response if the image is not found.
     */
    @GetMapping("/imagen/{id}")
    @ApiOperation(value = "Obtener imagen de un conocimiento", notes = "Recupera la imagen asociada a un conocimiento")
    @ResponseBody
    public ResponseEntity<byte[]> getImagen(@PathVariable Long id) {
        byte[] imagen = conocimientoService.getImagen(id);
        if (imagen != null) {
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(imagen);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
