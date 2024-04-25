package com.example.portafolio.Servicio;

import com.example.portafolio.Entidad.AcercaDeMi;
import com.example.portafolio.Repositorio.AcercaDeMiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AcercaDeMiService {

    @Autowired
    private AcercaDeMiRepository acercaDeMiRepository;

    public AcercaDeMi crear(AcercaDeMi acercaDeMi) {
        return acercaDeMiRepository.save(acercaDeMi);
    }

    public AcercaDeMi obtener(Long id) {
        return acercaDeMiRepository.findById(id).orElse(null);
    }

    public AcercaDeMi actualizar(AcercaDeMi acercaDeMi) {
        return acercaDeMiRepository.save(acercaDeMi);
    }

    public void eliminar(Long id) {
        acercaDeMiRepository.deleteById(id);
    }
}
