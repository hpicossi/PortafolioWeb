package com.example.portafolio.Servicio;

import com.example.portafolio.Entidad.Educacion;
import com.example.portafolio.Repositorio.EducacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionService {

    @Autowired
    private EducacionRepository educacionRepository;

    public Educacion crear(Educacion educacion) {
        return educacionRepository.save(educacion);
    }

    public Educacion obtener(Long id) {
        return educacionRepository.findById(id).orElse(null);
    }

    public Educacion actualizar(Educacion educacion) {
        return educacionRepository.save(educacion);
    }

    public void eliminar(Long id) {
        educacionRepository.deleteById(id);
    }
}
