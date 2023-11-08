package com.example.portafoliowebback.Controller;

import com.example.portafoliowebback.Dto.dtoContacto;
import com.example.portafoliowebback.Entity.Contacto;
import com.example.portafoliowebback.Service.SContacto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import java.lang.constant.Constable;
import java.util.List;

@RestController
@RequestMapping("/contacto")
@CrossOrigin(origins = "http://localhost:4200")
public class CContacto {

    @Autowired
    SContacto sContacto;

    @GetMapping("/lista")
    public ResponseEntity<List<Contacto>> list(){
        List<Contacto> list = sContacto.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Contacto> getById(@PathVariable("id")int id){
        if(!sContacto.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        Contacto contacto = sContacto.getOne(id).get();
        return new ResponseEntity(contacto, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sContacto.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        sContacto.delete(id);
        return new ResponseEntity(new Mensaje("Contacto se a eliminado"),HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoContacto dtocontacto){
        if(StringUtils.isEmptyOrWhitespace(dtocontacto.getGithubUrl())){
            return new ResponseEntity(new Mensaje("El link de github es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isEmptyOrWhitespace(dtocontacto.getLinkedinUrl())){
            return new ResponseEntity(new Mensaje("El link de linkedin es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Contacto contacto = new Contacto(
                dtocontacto.getGithubUrl(), dtocontacto.getLinkedinUrl()
        );

        sContacto.save(contacto);
        return new ResponseEntity(new Mensaje("Contacto creado"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoContacto dtocontacto){
        if(!sContacto.existsById(id)){
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isEmptyOrWhitespace(dtocontacto.getGithubUrl())){
            return new ResponseEntity(new Mensaje("El link de github es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isEmptyOrWhitespace(dtocontacto.getLinkedinUrl())){
            return new ResponseEntity(new Mensaje("El link de linkedin es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Contacto contacto = new Contacto(
                dtocontacto.getGithubUrl(), dtocontacto.getLinkedinUrl()
        );

        sContacto.save(contacto);
        return new ResponseEntity(new Mensaje("Contacto modificado"), HttpStatus.OK);
    }

}
