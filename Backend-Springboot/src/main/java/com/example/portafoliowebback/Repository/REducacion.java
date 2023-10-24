package com.example.portafoliowebback.Repository;

import com.example.portafoliowebback.Entity.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface REducacion extends JpaRepository<Educacion, Integer> {
    public Optional<Educacion> findByNombreE(String nombreE);
    public Optional<Educacion> findByDescripcionE(String DescripcionE);
    public boolean existsByNombreE(String nombreE);
    public boolean existsByDescripcionE(String descripcionE);
}
