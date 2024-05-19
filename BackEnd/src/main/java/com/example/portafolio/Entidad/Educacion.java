package com.example.portafolio.Entidad;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

/**
 * Represents the educational information of a user.
 * 
 * This entity class maps to the "educacion" table in the database and provides
 * properties to store the details of a user's educational background, such as
 * the name of the educational institution, the title or degree obtained, the
 * start and end dates of the education, and an optional description.
 */
@Entity
@Getter
@Setter
@Table(name = "educacion")
@ApiModel(value = "Entidad Educacion", description = "Representa la información educativa del usuario")
public class Educacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "ID único de la educación", name = "idEducacion")
    private Long id;

    @Column(name = "nombre_institucion", nullable = false, length = 255)
    @ApiModelProperty(value = "Nombre de la institución educativa", name = "nombreInstitucion", required = true)
    private String nombreInstitucion;

    @Column(name = "titulo", nullable = false, length = 255)
    @ApiModelProperty(value = "Título obtenido en la institución educativa", name = "titulo", required = true)
    private String titulo;

    @Column(name = "fecha_inicio", nullable = false)
    @ApiModelProperty(value = "Fecha de inicio de la educación", name = "fechaInicio", required = true, example = "2020-01-01")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    @ApiModelProperty(value = "Fecha de fin de la educación (opcional)", name = "fechaFin", example = "2023-12-31")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaFin;

    @Column(name = "descripcion", length = 500)
    @ApiModelProperty(value = "Descripción detallada de la educación", name = "descripcion")
    private String descripcion;

}