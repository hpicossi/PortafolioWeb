package com.example.portafolio.Repositorio;

import com.example.portafolio.Entidad.AcercaDeMi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface AcercaDeMiRepository extends JpaRepository<AcercaDeMi, Long> {

    // Buscar por nombre o palabras clave
    AcercaDeMi findByNombreContainingIgnoreCase(String nombre);
    List<AcercaDeMi> findByNombreContainingIgnoreCaseOrDescripcionContainingIgnoreCase(String nombre, String descripcion);

    // Filtrar por fecha de creación o actualización
    List<AcercaDeMi> findByFechaCreacionBetween(Date fechaInicio, Date fechaFin);
    List<AcercaDeMi> findByFechaActualizacionBetween(Date fechaInicio, Date fechaFin);

}
