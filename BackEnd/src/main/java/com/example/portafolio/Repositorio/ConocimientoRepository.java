package com.example.portafolio.Repositorio;


import com.example.portafolio.Entidad.Conocimiento;
import com.example.portafolio.Entidad.TipoConocimiento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConocimientoRepository extends JpaRepository<Conocimiento, Long> {

    // Buscar por nombre o palabras clave
    List<Conocimiento> findByNombreContainingIgnoreCase(String nombre);
    List<Conocimiento> findByDescripcionContainingIgnoreCase(String descripcion);

    // Filtrar por tipo de conocimiento
    List<Conocimiento> findByTipoConocimiento(TipoConocimiento tipoConocimiento);

}