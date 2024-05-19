package com.example.portafolio.Servicio;

import com.example.portafolio.Entidad.Proyecto;
import com.example.portafolio.Repositorio.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Provides service methods for managing projects, including retrieving all
 * projects, getting a project by ID, saving a new project, deleting a project,
 * and managing project images.
 */
@Service
public class ProyectoService {

    @Autowired
    private ProyectoRepository proyectoRepository;

    /**
     * Retrieves all the projects stored in the system.
     *
     * @return a list of all the projects
     */
    public List<Proyecto> getAllProyectos() {
        return proyectoRepository.findAll();
    }

    /**
     * Retrieves a project by its unique identifier.
     *
     * @param id the unique identifier of the project to retrieve
     * @return the project with the specified identifier, or null if not found
     */
    public Proyecto getProyectoById(Long id) {
        return proyectoRepository.findById(id).orElse(null);
    }

    /**
     * Saves a new project to the database.
     *
     * @param proyecto The project to be saved.
     * @return The saved project.
     */
    public Proyecto saveProyecto(Proyecto proyecto) {
        proyectoRepository.save(proyecto);
        return proyecto;
    }

    /**
     * Deletes a project by its ID.
     *
     * @param id the ID of the project to delete
     */
    public void deleteProyecto(Long id) {
        proyectoRepository.deleteById(id);
    }

    /**
     * Saves an image for the specified project.
     *
     * @param idProyecto the ID of the project to save the image for
     * @param imagen     the image data to save
     */
    public void saveImagen(Long idProyecto, byte[] imagen) {
        Proyecto proyecto = getProyectoById(idProyecto);
        proyecto.setImagen(imagen);
        proyectoRepository.save(proyecto);
    }

    /**
     * Retrieves the image associated with the specified project.
     *
     * @param idProyecto the ID of the project to retrieve the image for
     * @return the image data for the specified project
     */
    public byte[] getImagen(Long idProyecto) {
        Proyecto proyecto = getProyectoById(idProyecto);
        return proyecto.getImagen();
    }
}