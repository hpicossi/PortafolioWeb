package com.example.portafolio.Repositorio;


import com.example.portafolio.Entidad.Proyecto;
import com.example.portafolio.Entidad.Tecnologia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {

    // Buscar por nombre o palabras clave
    List<Proyecto> findByNombreContainingIgnoreCase(String nombre);
    List<Proyecto> findByDescripcionContainingIgnoreCase(String descripcion);

    // Filtrar por tecnologías utilizadas
    List<Proyecto> findByTecnologiasIn(Set<Tecnologia> tecnologias);

    // Ordenar por fecha de inicio o finalización
    List<Proyecto> findByOrderByFechaInicioAsc();
    List<Proyecto> findByOrderByFechaInicioDesc();
    List<Proyecto> findByOrderByFechaFinAsc();
    List<Proyecto> findByOrderByFechaFinDesc();

    // Buscar proyectos destacados
    List<Proyecto> findByDestacadaTrue();

}