package com.example.portafoliowebback.Security.Service;

import com.example.portafoliowebback.Security.Entity.Usuario;
import com.example.portafoliowebback.Security.Repository.iUsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    iUsuarioRepository iusuarioRepository;

    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
        return iusuarioRepository.findByNombreUsuario(nombreUsuario);
    }

    public boolean existsByNombreUsuario(String nombreUsuario){
        return iusuarioRepository.existsByNombreUsuario(nombreUsuario);
    }

    public boolean existsByEmail(String nombreUsuario){
        return iusuarioRepository.existsByEmail(nombreUsuario);
    }

    public void save(Usuario usuario){
        iusuarioRepository.save(usuario);
    }
}
