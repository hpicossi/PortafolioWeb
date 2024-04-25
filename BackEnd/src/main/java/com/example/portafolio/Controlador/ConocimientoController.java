package com.example.portafolio.Controlador;

import com.example.portafolio.Entidad.Conocimiento;
import com.example.portafolio.Servicio.ConocimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/conocimiento")
public class ConocimientoController {

    @Autowired
    private ConocimientoService conocimientoService;

    @GetMapping
    public List<Conocimiento> getAllConocimientos() {
        return conocimientoService.getAllConocimientos();
    }

    @GetMapping("/{id}")
    public Conocimiento getConocimientoById(@PathVariable Long id) {
        return conocimientoService.getConocimientoById(id);
    }

    @PostMapping
    public Conocimiento saveConocimiento(@RequestBody Conocimiento conocimiento) {
        return conocimientoService.saveConocimiento(conocimiento);
    }

    @DeleteMapping("/{id}")
    public void deleteConocimiento(@PathVariable Long id) {
        conocimientoService.deleteConocimiento(id);
    }

    @PostMapping("/imagen/{id}")
    public void saveImagen(@PathVariable Long id, @RequestParam("imagen") MultipartFile imagen) {
        try {
            byte[] bytes = imagen.getBytes();
            conocimientoService.saveImagen(id, bytes);
        } catch (IOException e) {
            // Manejar la excepción de E/S
        }
    }

    @GetMapping("/imagen/{id}")
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
