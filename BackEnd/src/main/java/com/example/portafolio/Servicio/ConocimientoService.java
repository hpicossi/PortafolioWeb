package com.example.portafolio.Servicio;

import com.example.portafolio.Entidad.Conocimiento;
import com.example.portafolio.Repositorio.ConocimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConocimientoService {

    @Autowired
    private ConocimientoRepository conocimientoRepository;

    public List<Conocimiento> getAllConocimientos() {
        return conocimientoRepository.findAll();
    }

    public Conocimiento getConocimientoById(Long id) {
        return conocimientoRepository.findById(id).orElse(null);
    }

    public Conocimiento saveConocimiento(Conocimiento conocimiento) {
        conocimientoRepository.save(conocimiento);
        return conocimiento;
    }

    public void deleteConocimiento(Long id) {
        conocimientoRepository.deleteById(id);
    }

    public void saveImagen(Long idConocimiento, byte[] imagen) {
        Conocimiento conocimiento = getConocimientoById(idConocimiento);
        conocimiento.setImagen(imagen);
        conocimientoRepository.save(conocimiento);
    }

    public byte[] getImagen(Long idConocimiento) {
        Conocimiento conocimiento = getConocimientoById(idConocimiento);
        return conocimiento.getImagen();
    }
}
