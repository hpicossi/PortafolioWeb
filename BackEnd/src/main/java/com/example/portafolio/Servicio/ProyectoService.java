package com.example.portafolio.Servicio;

import com.example.portafolio.Entidad.Proyecto;
import com.example.portafolio.Repositorio.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProyectoService {

    @Autowired
    private ProyectoRepository proyectoRepository;

    public List<Proyecto> getAllProyectos() {
        return proyectoRepository.findAll();
    }

    public Proyecto getProyectoById(Long id) {
        return proyectoRepository.findById(id).orElse(null);
    }

    public Proyecto saveProyecto(Proyecto proyecto) {
        proyectoRepository.save(proyecto);
        return proyecto;
    }

    public void deleteProyecto(Long id) {
        proyectoRepository.deleteById(id);
    }

    public void saveImagen(Long idProyecto, byte[] imagen) {
        Proyecto proyecto = getProyectoById(idProyecto);
        proyecto.setImagen(imagen);
        proyectoRepository.save(proyecto);
    }

    public byte[] getImagen(Long idProyecto) {
        Proyecto proyecto = getProyectoById(idProyecto);
        return proyecto.getImagen();
    }
}