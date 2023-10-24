package com.example.portafoliowebback.Service;

import com.example.portafoliowebback.Entity.Educacion;
import com.example.portafoliowebback.Repository.REducacion;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SEducacion {
    @Autowired
    REducacion rEducacion;

    public List<Educacion> list(){
        return rEducacion.findAll();
    }

    public Optional<Educacion> getOne(int id){
        return rEducacion.findById(id);
    }

    public Optional<Educacion> getByNombreE(String nombreE){
        return rEducacion.findByNombreE(nombreE);
    }

    public Optional<Educacion> getByDescripcion(String descripcionE){
        return rEducacion.findByDescripcionE(descripcionE);
    }
    public void save(Educacion educacion){
        rEducacion.save(educacion);
    }

    public void delete(int id){
        rEducacion.deleteById(id);
    }

    public boolean existsById(int id){
        return rEducacion.existsById(id);
    }

    public boolean existsByNombreE(String nombreE){
        return rEducacion.existsByNombreE(nombreE);
    }

    public boolean existsByDescripcionE(String descripcionE){
        return rEducacion.existsByDescripcionE(descripcionE);
    }
}
