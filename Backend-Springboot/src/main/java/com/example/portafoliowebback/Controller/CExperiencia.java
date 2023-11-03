package com.example.portafoliowebback.Controller;

import com.example.portafoliowebback.Dto.dtoExperiencia;
import com.example.portafoliowebback.Entity.Experiencia;
import com.example.portafoliowebback.Service.SExperiencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import java.util.List;

@RestController
@RequestMapping("experiencia")
@CrossOrigin(origins = "http://localhost:4200")

public class CExperiencia {

    @Autowired
    SExperiencia sExperiencia;

    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list(){
        List<Experiencia> list = sExperiencia.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!sExperiencia.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        Experiencia experiencia = sExperiencia.getOne(id).get();
        return new ResponseEntity<>(experiencia, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if (!sExperiencia.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        sExperiencia.delete(id);
        return new ResponseEntity(new Mensaje("Experiencia creada"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoExperiencia dtoexperiencia){
        if (StringUtils.isEmptyOrWhitespace(dtoexperiencia.getNombreExp())) {
            return new ResponseEntity(new Mensaje("El nombre de experiencia es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isEmptyOrWhitespace(dtoexperiencia.getNombreEmpresaExp())) {
            return new ResponseEntity(new Mensaje("El nombre de la empresa de experiencia es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isEmptyOrWhitespace(dtoexperiencia.getDescripcionExp())) {
            return new ResponseEntity(new Mensaje("La descripcion de experiencia es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isEmptyOrWhitespace(dtoexperiencia.getAptitudesExp())) {
            return new ResponseEntity(new Mensaje("La aptitud de experiencia es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Experiencia experiencia = new Experiencia(
                dtoexperiencia.getNombreExp(), dtoexperiencia.getNombreEmpresaExp(), dtoexperiencia.getDescripcionExp(), dtoexperiencia.getAptitudesExp()
        );
        sExperiencia.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia creada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id,@RequestBody dtoExperiencia dtoexperiencia){
        if (!sExperiencia.existsById(id)){
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isEmptyOrWhitespace(dtoexperiencia.getNombreExp())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isEmptyOrWhitespace(dtoexperiencia.getNombreEmpresaExp())){
            return new ResponseEntity(new Mensaje("El nombre de empresa es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isEmptyOrWhitespace(dtoexperiencia.getDescripcionExp())){
            return new ResponseEntity<>(new Mensaje("La descripcion es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isEmptyOrWhitespace(dtoexperiencia.getAptitudesExp())){
            return new ResponseEntity<>(new Mensaje("La actitud es obligatoria"), HttpStatus.BAD_REQUEST);
        }

        Experiencia experiencia = sExperiencia.getOne(id).get();
        experiencia.setNombreExp(dtoexperiencia.getNombreExp());
        experiencia.setNombreEmpresaExp(dtoexperiencia.getNombreEmpresaExp());
        experiencia.setDescripcionExp(dtoexperiencia.getDescripcionExp());
        experiencia.setAptitudesExp(dtoexperiencia.getAptitudesExp());

        sExperiencia.save(experiencia);
        return new ResponseEntity<>(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
    }
}
