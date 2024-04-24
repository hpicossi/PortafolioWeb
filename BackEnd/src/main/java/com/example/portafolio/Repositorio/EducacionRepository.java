package com.example.portafolio.Repositorio;

import com.example.portafolio.Entidad.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducacionRepository extends JpaRepository<Educacion, Long> {

    // Ordenar por fecha de inicio o finalización
    List<Educacion> findByOrderByFechaInicioAsc();
    List<Educacion> findByOrderByFechaInicioDesc();
    List<Educacion> findByOrderByFechaFinAsc();
    List<Educacion> findByOrderByFechaFinDesc();

    // Filtrar por institución o nivel educativo
    List<Educacion> findByInstitucion(String institucion);
    List<Educacion> findByNivelEducativo(String nivelEducativo);

}
