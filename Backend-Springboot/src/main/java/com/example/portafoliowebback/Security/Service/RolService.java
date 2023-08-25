package com.example.portafoliowebback.Security.Service;

import com.example.portafoliowebback.Security.Entity.Rol;
import com.example.portafoliowebback.Security.Enums.RolNombre;
import com.example.portafoliowebback.Security.Repository.iRolRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class RolService {
    @Autowired
    iRolRepository irolRepository;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return irolRepository.findByRolNombre(rolNombre);
    }

    public void save(Rol rol){
        irolRepository.save(rol);
    }
}
