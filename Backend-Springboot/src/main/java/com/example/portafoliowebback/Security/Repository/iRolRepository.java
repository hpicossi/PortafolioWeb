package com.example.portafoliowebback.Security.Repository;

import com.example.portafoliowebback.Security.Entity.Rol;
import com.example.portafoliowebback.Security.Enums.RolNombre;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface iRolRepository {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);

    void save(Rol rol);
}
