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

@RestController
@RequestMapping("/conocimiento")
@Api(value = "Controlador de Conocimientos", description = "Operaciones CRUD para la gestión de conocimientos")
public class ConocimientoController {

    @Autowired
    private ConocimientoService conocimientoService;

    @GetMapping
    @ApiOperation(value = "Obtener todos los conocimientos", notes = "Recupera una lista de todos los conocimientos existentes")
    public List<Conocimiento> getAllConocimientos() {
        return conocimientoService.getAllConocimientos();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtener un conocimiento por ID", notes = "Recupera un conocimiento específico por su ID")
    public Conocimiento getConocimientoById(@PathVariable Long id) {
        return conocimientoService.getConocimientoById(id);
    }

    @PostMapping
    @ApiOperation(value = "Crear un nuevo conocimiento", notes = "Crea un nuevo conocimiento en la base de datos")
    public Conocimiento saveConocimiento(@RequestBody Conocimiento conocimiento) {
        return conocimientoService.saveConocimiento(conocimiento);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar un conocimiento", notes = "Elimina un conocimiento existente de la base de datos")
    public void deleteConocimiento(@PathVariable Long id) {
        conocimientoService.deleteConocimiento(id);
    }

    @PostMapping("/imagen/{id}")
    @ApiOperation(value = "Subir imagen a un conocimiento", notes = "Sube una imagen a un conocimiento existente")
    public void saveImagen(@PathVariable Long id, @RequestParam("imagen") MultipartFile imagen) {
        try {
            byte[] bytes = imagen.getBytes();
            conocimientoService.saveImagen(id, bytes);
        } catch (IOException e) {
            // Manejar la excepción de E/S
        }
    }

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
