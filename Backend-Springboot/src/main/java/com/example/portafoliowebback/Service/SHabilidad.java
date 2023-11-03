package com.example.portafoliowebback.Service;

import com.example.portafoliowebback.Entity.Habilidad;
import com.example.portafoliowebback.Repository.RHabilidad;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SHabilidad {

    @Autowired
    RHabilidad rHabilidad;

    public List<Habilidad> list() { return rHabilidad.findAll();}

    public Optional<Habilidad> getOne(int id) {return rHabilidad.findById(id);}

    public Optional<Habilidad> getByNombreH(String nombreH) {return rHabilidad.findByNombreH(nombreH);}

    public void save(Habilidad habilidad) { rHabilidad.save(habilidad);}

    public void delete(int id) { rHabilidad.deleteById(id);}

    public boolean existsById(int id) {return rHabilidad.existsById(id);}

    public boolean existsByNombreH(String nombreH) {return rHabilidad.existsByNombreH(nombreH);}
}
