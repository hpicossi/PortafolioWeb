package com.example.portafolio.Servicio;

import com.example.portafolio.Entidad.Conocimiento;
import com.example.portafolio.Repositorio.ConocimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Provides service methods for managing knowledge (Conocimiento) entities.
 * This service class interacts with the ConocimientoRepository to perform CRUD
 * operations on Conocimiento entities.
 */
@Service
public class ConocimientoService {

    @Autowired
    private ConocimientoRepository conocimientoRepository;

    /**
     * Retrieves all the knowledge items (Conocimientos) from the repository.
     *
     * @return a list of all the knowledge items
     */
    public List<Conocimiento> getAllConocimientos() {
        return conocimientoRepository.findAll();
    }

    /**
     * Retrieves a {@link Conocimiento} entity by its unique identifier.
     *
     * @param id the unique identifier of the {@link Conocimiento} entity
     * @return the {@link Conocimiento} entity with the specified ID, or
     *         {@code null} if not found
     */
    public Conocimiento getConocimientoById(Long id) {
        return conocimientoRepository.findById(id).orElse(null);
    }

    /**
     * Saves a new {@link Conocimiento} entity to the database.
     *
     * @param conocimiento the {@link Conocimiento} entity to be saved
     * @return the saved {@link Conocimiento} entity
     */
    public Conocimiento saveConocimiento(Conocimiento conocimiento) {
        conocimientoRepository.save(conocimiento);
        return conocimiento;
    }

    /**
     * Deletes a knowledge item (Conocimiento) by its ID.
     *
     * @param id The ID of the knowledge item to delete.
     */
    public void deleteConocimiento(Long id) {
        conocimientoRepository.deleteById(id);
    }

    /**
     * Saves an image associated with a specific knowledge item.
     *
     * @param idConocimiento the ID of the knowledge item to associate the image
     *                       with
     * @param imagen         the image data to save
     */
    public void saveImagen(Long idConocimiento, byte[] imagen) {
        Conocimiento conocimiento = getConocimientoById(idConocimiento);
        conocimiento.setImagen(imagen);
        conocimientoRepository.save(conocimiento);
    }

    /**
     * Retrieves the image associated with the specified knowledge item.
     *
     * @param idConocimiento the ID of the knowledge item
     * @return the image data for the specified knowledge item
     */
    public byte[] getImagen(Long idConocimiento) {
        Conocimiento conocimiento = getConocimientoById(idConocimiento);
        return conocimiento.getImagen();
    }
}
