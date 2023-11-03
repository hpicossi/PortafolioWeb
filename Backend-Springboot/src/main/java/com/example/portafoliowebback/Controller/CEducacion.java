package com.example.portafoliowebback.Controller;

import com.example.portafoliowebback.Dto.dtoEducacion;
import com.example.portafoliowebback.Entity.Educacion;
import com.example.portafoliowebback.Service.SEducacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import java.util.List;

@RestController
@RequestMapping("/educacion")
@CrossOrigin(origins = "http://localhost:4200")
public class CEducacion {
    @Autowired
    SEducacion sEducacion;
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list() {
            List<Educacion> list = sEducacion.list();
            return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if(!sEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        Educacion educacion = sEducacion.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int  id){
        if(!sEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el Id"), HttpStatus.NOT_FOUND);
        }
        sEducacion.delete(id);
        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoeducacion){
        if (StringUtils.isEmptyOrWhitespace(dtoeducacion.getNombreE())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sEducacion.existsByNombreE(dtoeducacion.getNombreE())){
            return new ResponseEntity(new Mensaje("Ese nombre ya Existe"), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = new Educacion(
                dtoeducacion.getNombreE(), dtoeducacion.getDescripcionE(), dtoeducacion.getActitudE()
        );
        sEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion creada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoeducacion){
        if(!sEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.NOT_FOUND);
        }
        if (sEducacion.existsByNombreE(dtoeducacion.getNombreE()) && sEducacion.getByNombreE(dtoeducacion.getNombreE()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isEmptyOrWhitespace(dtoeducacion.getNombreE())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio o con espacios"), HttpStatus.BAD_REQUEST);
        }
        Educacion educacion = sEducacion.getOne(id).get();

        educacion.setNombreE(dtoeducacion.getNombreE());
        educacion.setDescripcionE(dtoeducacion.getDescripcionE());
        educacion.setActitudE(dtoeducacion.getActitudE());

        sEducacion.save(educacion);

        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
    }
}
