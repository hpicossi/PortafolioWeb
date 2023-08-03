package com.example.portafoliowebback.Interface;

import com.example.portafoliowebback.Entity.Persona;

import java.util.List;

public interface IPersonaService {

     List<Persona> getPersona();

     Persona findPersona(long id);

     void savePersona(Persona persona);

     void deletePersona(Long id);

}
