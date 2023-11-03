package com.example.portafoliowebback.Repository;

import com.example.portafoliowebback.Entity.Habilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RHabilidad extends JpaRepository<Habilidad, Integer> {

    public Optional<Habilidad> findByNombreH(String nombreH);

    public boolean existsByNombreH(String nombreH);
}
