package com.example.portafolio.Controlador;

import com.example.portafolio.Entidad.Proyecto;
import com.example.portafolio.Servicio.ProyectoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/proyecto")
@Api(value = "Controlador de Proyecto", description = "Operaciones CRUD para la gestión de proyecto")
public class ProyectoController {

    @Autowired
    private ProyectoService proyectoService;

    @GetMapping
    @ApiOperation(value = "Obtener todos los proyectos", notes = "Recupera una lista de todos los proyectos existentes")
    public List<Proyecto> getAllProyectos() {
        return proyectoService.getAllProyectos();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtener un proyecto por ID", notes = "Recupera un proyecto específico por su ID")
    public Proyecto getProyectoById(@PathVariable Long id) {
        return proyectoService.getProyectoById(id);
    }

    @PostMapping
    @ApiOperation(value = "Crear un nuevo proyecto", notes = "Crea un nuevo proyecto en la base de datos")
    public Proyecto saveProyecto(@RequestBody Proyecto proyecto) {
        return proyectoService.saveProyecto(proyecto);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar un proyecto", notes = "Elimina un proyecto existente de la base de datos")
    public void deleteProyecto(@PathVariable Long id) {
        proyectoService.deleteProyecto(id);
    }

    @PostMapping("/imagen/{id}")
    @ApiOperation(value = "Subir imagen a un proyecto", notes = "Sube una imagen a un proyecto existente")
    public void saveImagen(@PathVariable Long id, @RequestParam("imagen") MultipartFile imagen) {
        try {
            byte[] bytes = imagen.getBytes();
            proyectoService.saveImagen(id, bytes);
        } catch (IOException e) {
            // Manejar la excepción de E/S
        }
    }

    @GetMapping("/imagen/{id}")
    @ResponseBody
    @ApiOperation(value = "Obtener imagen de un proyecto", notes = "Recupera la imagen asociada a un proyecto")
    public ResponseEntity<byte[]> getImagen(@PathVariable Long id) {
        byte[] imagen = proyectoService.getImagen(id);
        if (imagen != null) {
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(imagen);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
