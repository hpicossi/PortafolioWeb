package com.example.portafolio.Entidad;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "acerca_de_mi")
@Api(value = "Acerca De Mi Model")  // Add Api annotation
public class AcercaDeMi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "ID único del registro")  // Add ApiModelProperty annotation
    private Long id;

    @Column(name = "descripcion", nullable = false, length = 500)
    @ApiModelProperty(value = "Descripción personal del usuario")  // Add ApiModelProperty annotation
    private String descripcion;

}