package com.example.portafoliowebback.Controller;

import com.example.portafoliowebback.Dto.dtoHabilidad;
import com.example.portafoliowebback.Entity.Habilidad;
import com.example.portafoliowebback.Service.SHabilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import java.util.List;

@RestController
@RequestMapping("/habilidad")
@CrossOrigin(origins = "http://localhost:4200")
public class CHabilidad {

    @Autowired
    SHabilidad sHabilidad;

    @GetMapping("/lista")
    public ResponseEntity<List<Habilidad>> list(){
        List<Habilidad> list = sHabilidad.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Habilidad> getById(@PathVariable("id") int id){
        if(!sHabilidad.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        Habilidad habilidad = sHabilidad.getOne(id).get();
        return new ResponseEntity(habilidad, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if (!sHabilidad.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        sHabilidad.delete(id);
        return new ResponseEntity(new Mensaje("Habilidad eliminada"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoHabilidad dtohabilidad){
        if(StringUtils.isEmptyOrWhitespace(dtohabilidad.getNombreH())){
            return new ResponseEntity(new Mensaje("El nombre de habilidad es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Habilidad habilidad = new Habilidad(
                dtohabilidad.getNombreH()
        );

        sHabilidad.save(habilidad);
        return new ResponseEntity(new Mensaje("Habilidad creada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoHabilidad dtohabilidad){
        if (!sHabilidad.existsById(id)){
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isEmptyOrWhitespace(dtohabilidad.getNombreH())){
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Habilidad habilidad = sHabilidad.getOne(id).get();
        habilidad.setNombreH(dtohabilidad.getNombreH());

        sHabilidad.save(habilidad);
        return new ResponseEntity(new Mensaje("Habilidad modificada"), HttpStatus.OK);
    }
}
