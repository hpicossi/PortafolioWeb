package com.example.portafolio.Interface;

import com.example.portafolio.Entidad.AcercaDeMi;

public interface AcercaDeMiService {

    AcercaDeMi guardarAcercaDeMi(AcercaDeMi acercaDeMi);

    AcercaDeMi obtenerAcercaDeMiPorId(Long id);

    void eliminarAcercaDeMi(Long id);

}