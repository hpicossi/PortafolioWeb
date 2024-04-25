package com.example.portafolio.Controlador;

import com.example.portafolio.Entidad.Proyecto;
import com.example.portafolio.Servicio.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/proyecto")
public class ProyectoController {

    @Autowired
    private ProyectoService proyectoService;

    @GetMapping
    public List<Proyecto> getAllProyectos() {
        return proyectoService.getAllProyectos();
    }

    @GetMapping("/{id}")
    public Proyecto getProyectoById(@PathVariable Long id) {
        return proyectoService.getProyectoById(id);
    }

    @PostMapping
    public Proyecto saveProyecto(@RequestBody Proyecto proyecto) {
        return proyectoService.saveProyecto(proyecto);
    }

    @DeleteMapping("/{id}")
    public void deleteProyecto(@PathVariable Long id) {
        proyectoService.deleteProyecto(id);
    }

    @PostMapping("/imagen/{id}")
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
