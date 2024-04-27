package com.example.portafolio.Controlador;

import com.example.portafolio.Entidad.Educacion;
import com.example.portafolio.Servicio.EducacionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/educacion")
@Api(value = "Controlador de Educacion", description = "Operaciones CRUD para la gestión de educacion")
public class EducacionController {

    @Autowired
    private EducacionService educacionService;

    @PostMapping
    @ApiOperation(value = "Crear una nueva educación", notes = "Crea una nueva educación en la base de datos")
    public Educacion crear(@RequestBody Educacion educacion) {
        return educacionService.crear(educacion);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtener una educación por ID", notes = "Recupera una educación específica por su ID")
    public Educacion obtener(@PathVariable Long id) {
        return educacionService.obtener(id);
    }

    @PutMapping
    @ApiOperation(value = "Actualizar una educación", notes = "Actualiza una educación existente en la base de datos")
    public Educacion actualizar(@RequestBody Educacion educacion) {
        return educacionService.actualizar(educacion);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar una educación", notes = "Elimina una educación existente de la base de datos")
    public void eliminar(@PathVariable Long id) {
        educacionService.eliminar(id);
    }
}
