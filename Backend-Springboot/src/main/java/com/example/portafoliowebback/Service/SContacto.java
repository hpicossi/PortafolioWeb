package com.example.portafoliowebback.Service;

import com.example.portafoliowebback.Entity.Contacto;
import com.example.portafoliowebback.Repository.RContacto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SContacto {

    @Autowired
    RContacto rContacto;

    public List<Contacto> list() { return rContacto.findAll();}

    public Optional<Contacto> getOne(int id){ return rContacto.findById(id);}

    public Optional<Contacto> getByGithubUrl(String githubUrl) { return rContacto.findByGithubUrl(githubUrl);}

    public void save(Contacto contacto) { rContacto.save(contacto);}

    public void delete(int id) { rContacto.deleteById(id);}

    public boolean existsById(int id) { return rContacto.existsById(id);}

    public boolean existsByGithubUrl(String githubUrl) { return rContacto.existsByGithubUrl(githubUrl);}


}
