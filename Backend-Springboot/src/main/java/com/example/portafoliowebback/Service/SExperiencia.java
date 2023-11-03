package com.example.portafoliowebback.Service;

import com.example.portafoliowebback.Entity.Educacion;
import com.example.portafoliowebback.Entity.Experiencia;
import com.example.portafoliowebback.Repository.RExperiencia;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SExperiencia {

    @Autowired
    RExperiencia rExperiencia;

    public List<Experiencia> list(){
        return rExperiencia.findAll();
    }

    public Optional<Experiencia> getOne(int id){
        return rExperiencia.findById(id);
    }

    public Optional<Experiencia> getByNombreExp(String nombreExp){
        return rExperiencia.findByNombreExp(nombreExp);
    }

    public void save(Experiencia experiencia){
        rExperiencia.save(experiencia);
    }

    public void delete(int id){
        rExperiencia.deleteById(id);
    }

    public boolean existsById(int id){
        return rExperiencia.existsById(id);
    }

    public boolean existsByNombreExp(String nombreE){
        return rExperiencia.existsByNombreExp(nombreE);
    }
}
