package com.example.portafoliowebback.Service;

import com.example.portafoliowebback.Entity.Proyecto;
import com.example.portafoliowebback.Repository.RProyecto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SProyecto {

    @Autowired
    RProyecto rProyecto;

    public List<Proyecto> list() { return rProyecto.findAll();}

    public Optional<Proyecto> getOne(int id) {return rProyecto.findById(id);}

    public Optional<Proyecto> getLink(String link) {return rProyecto.findByLink(link);}

    public void save(Proyecto proyecto) { rProyecto.save(proyecto);}

    public void delete(int id){rProyecto.deleteById(id);}

    public boolean existsById(int id) {return rProyecto.existsById(id);}

    public boolean existsByLink(String link) {return rProyecto.existsByLink(link); }

}
