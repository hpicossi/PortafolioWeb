package com.example.portafoliowebback.Repository;

import com.example.portafoliowebback.Entity.Contacto;
import com.example.portafoliowebback.Entity.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ConcurrentModificationException;
import java.util.Optional;

@Repository
public interface RContacto extends JpaRepository<Contacto, Integer> {
    public Optional<Contacto> findByGithubUrl(String githubUrl);
    public boolean existsByGithubUrl(String githubUrl);
}
