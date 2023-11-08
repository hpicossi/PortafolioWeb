package com.example.portafoliowebback.Repository;

import com.example.portafoliowebback.Entity.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RProyecto extends JpaRepository<Proyecto, Integer> {

    public Optional<Proyecto> findByLink(String link);

    public boolean existsByLink(String link);
}
