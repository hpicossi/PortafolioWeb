package com.example.portafolio.Servicio;

import com.example.portafolio.Entidad.Educacion;
import com.example.portafolio.Repositorio.EducacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Provides CRUD operations for managing education records.
 */
@Service
public class EducacionService {

    @Autowired
    private EducacionRepository educacionRepository;

    /**
     * Creates a new Educacion entity and saves it to the repository.
     *
     * @param educacion the Educacion entity to be created
     * @return the saved Educacion entity
     */
    public Educacion crear(Educacion educacion) {
        return educacionRepository.save(educacion);
    }

    /**
     * Retrieves an Educacion entity by its ID.
     *
     * @param id the ID of the Educacion entity to retrieve
     * @return the Educacion entity with the specified ID, or null if not found
     */
    public Educacion obtener(Long id) {
        return educacionRepository.findById(id).orElse(null);
    }

    /**
     * Updates an existing Educacion entity in the database.
     *
     * @param educacion the Educacion entity to be updated
     * @return the updated Educacion entity
     */
    public Educacion actualizar(Educacion educacion) {
        return educacionRepository.save(educacion);
    }

    /**
     * Deletes an education record by its ID.
     *
     * @param id the ID of the education record to delete
     */
    public void eliminar(Long id) {
        educacionRepository.deleteById(id);
    }
}
