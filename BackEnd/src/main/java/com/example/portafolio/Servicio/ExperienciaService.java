package com.example.portafolio.Servicio;

import com.example.portafolio.Entidad.Experiencia;
import com.example.portafolio.Repositorio.ExperienciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Provides service methods for managing Experiencia entities in the
 * application.
 */

@Service
public class ExperienciaService {

    @Autowired
    private ExperienciaRepository experienciaRepository;

    /**
     * Creates a new Experiencia entity and saves it to the repository.
     *
     * @param experiencia the Experiencia entity to be created
     * @return the saved Experiencia entity
     */
    public Experiencia crear(Experiencia experiencia) {
        return experienciaRepository.save(experiencia);
    }

    /**
     * Retrieves an {@link Experiencia} entity by its ID.
     *
     * @param id the ID of the {@link Experiencia} to retrieve
     * @return the {@link Experiencia} entity with the specified ID, or {@code null}
     *         if not found
     */
    public Experiencia obtener(Long id) {
        return experienciaRepository.findById(id).orElse(null);
    }

    /**
     * Updates an existing Experiencia entity in the database.
     *
     * @param experiencia the Experiencia entity to be updated
     * @return the updated Experiencia entity
     */
    public Experiencia actualizar(Experiencia experiencia) {
        return experienciaRepository.save(experiencia);
    }

    /**
     * Deletes an experience by its ID.
     *
     * @param id the ID of the experience to delete
     */
    public void eliminar(Long id) {
        experienciaRepository.deleteById(id);
    }
}