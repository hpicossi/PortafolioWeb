package com.example.portafolio.Servicio;

import com.example.portafolio.Entidad.AcercaDeMi;
import com.example.portafolio.Repositorio.AcercaDeMiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for managing the "About Me" section of the application.
 * Provides methods to create, retrieve, update, and delete "About Me"
 * information.
 */
@Service
public class AcercaDeMiService {

    @Autowired
    private AcercaDeMiRepository acercaDeMiRepository;

    /**
     * Creates a new instance of AcercaDeMi and saves it to the repository.
     *
     * @param acercaDeMi the AcercaDeMi instance to be saved
     * @return the saved AcercaDeMi instance
     */
    public AcercaDeMi crear(AcercaDeMi acercaDeMi) {
        return acercaDeMiRepository.save(acercaDeMi);
    }

    /**
     * Retrieves an {@link AcercaDeMi} entity by its ID.
     *
     * @param id the ID of the {@link AcercaDeMi} entity to retrieve
     * @return the {@link AcercaDeMi} entity with the specified ID, or {@code null}
     *         if not found
     */
    public AcercaDeMi obtener(Long id) {
        return acercaDeMiRepository.findById(id).orElse(null);
    }

    /**
     * Updates an existing AcercaDeMi entity in the database.
     *
     * @param acercaDeMi the AcercaDeMi entity to be updated
     * @return the updated AcercaDeMi entity
     */
    public AcercaDeMi actualizar(AcercaDeMi acercaDeMi) {
        return acercaDeMiRepository.save(acercaDeMi);
    }

    /**
     * Deletes the entity with the specified ID from the repository.
     *
     * @param id the ID of the entity to delete
     */
    public void eliminar(Long id) {
        acercaDeMiRepository.deleteById(id);
    }
}
