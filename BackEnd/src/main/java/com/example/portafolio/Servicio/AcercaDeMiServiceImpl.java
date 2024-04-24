package com.example.portafolio.Servicio;

import com.example.portafolio.Entidad.AcercaDeMi;
import com.example.portafolio.Interface.AcercaDeMiService;
import com.example.portafolio.Repositorio.AcercaDeMiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AcercaDeMiServiceImpl implements AcercaDeMiService {

    @Autowired
    private AcercaDeMiRepository acercaDeMiRepository;

    @Override
    public AcercaDeMi guardarAcercaDeMi(AcercaDeMi acercaDeMi) {
        return acercaDeMiRepository.save(acercaDeMi);
    }

    @Override
    public AcercaDeMi obtenerAcercaDeMiPorId(Long id) {
        return acercaDeMiRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminarAcercaDeMi(Long id) {
        acercaDeMiRepository.deleteById(id);
    }

}
