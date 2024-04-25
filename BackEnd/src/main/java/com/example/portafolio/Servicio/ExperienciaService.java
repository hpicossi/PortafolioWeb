package com.example.portafolio.Servicio;

import com.example.portafolio.Entidad.Experiencia;
import com.example.portafolio.Repositorio.ExperienciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaService {

    @Autowired
    private ExperienciaRepository experienciaRepository;

    public Experiencia crear(Experiencia experiencia) {
        return experienciaRepository.save(experiencia);
    }

    public Experiencia obtener(Long id) {
        return experienciaRepository.findById(id).orElse(null);
    }

    public Experiencia actualizar(Experiencia experiencia) {
        return experienciaRepository.save(experiencia);
    }

    public void eliminar(Long id) {
        experienciaRepository.deleteById(id);
    }
}