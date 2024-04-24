package com.example.portafolio.Repositorio;

import com.example.portafolio.Entidad.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface ExperienciaRepository extends JpaRepository<Experiencia, Long> {

    // Buscar por empresa o cargo
    List<Experiencia> findByEmpresaContainingIgnoreCase(String empresa);
    List<Experiencia> findByCargoContainingIgnoreCase(String cargo);

    // Filtrar por rango de fechas
    List<Experiencia> findByFechaInicioBetween(Date fechaInicio, Date fechaFin);
    List<Experiencia> findByFechaFinBetween(Date fechaInicio, Date fechaFin);

    // Ordenar por relevancia o antigüedad
    List<Experiencia> findByDestacadaTrueOrderByFechaInicioDesc();
    List<Experiencia> findByDestacadaFalseOrderByFechaInicioDesc();

}
