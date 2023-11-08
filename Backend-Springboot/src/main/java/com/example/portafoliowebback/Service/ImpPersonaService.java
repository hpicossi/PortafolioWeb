package com.example.portafoliowebback.Service;

import com.example.portafoliowebback.Entity.Persona;
import com.example.portafoliowebback.Interface.IPersonaService;
import com.example.portafoliowebback.Repository.IPersonaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ImpPersonaService implements IPersonaService {

    final IPersonaRepository iPersonaRepository;

    public ImpPersonaService(IPersonaRepository iPersonaRepository) {
        this.iPersonaRepository = iPersonaRepository;
    }

    @Override
    public List<Persona> getPersona() {
        return iPersonaRepository.findAll();
    }

    @Override
    public Persona findPersona(long id) {
        return iPersonaRepository.findById(id).orElse(null);
    }

    @Override
    public void savePersona(Persona persona) {
        iPersonaRepository.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        iPersonaRepository.deleteById(id);
    }
}
