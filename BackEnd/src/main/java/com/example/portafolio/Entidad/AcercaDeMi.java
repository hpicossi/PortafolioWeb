package com.example.portafolio.Entidad;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


/**
 * Represents the "About Me" entity, which contains personal information about a
 * user.
 *
 */

@Entity
@Getter
@Setter
@Table(name = "acerca_de_mi")
@Api(value = "Acerca De Mi Model") // Add Api annotation
public class AcercaDeMi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "ID único del registro")
    private Long id;

    @Column(name = "descripcion", nullable = false, length = 500)
    @ApiModelProperty(value = "Descripción personal del usuario")
    private String descripcion;

}