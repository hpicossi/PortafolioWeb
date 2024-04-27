package com.example.portafolio.Entidad;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Getter
@Setter
@Table(name = "experiencia")
@ApiModel(value = "Entidad Experiencia", description = "Representa la experiencia laboral del usuario")
public class Experiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "ID único de la experiencia", name = "idExperiencia")
    private Long id;

    @Column(name = "nombre_empresa", nullable = false, length = 255)
    @ApiModelProperty(value = "Nombre de la empresa donde se desempeñó la experiencia", name = "nombreEmpresa", required = true)
    private String nombreEmpresa;

    @Column(name = "cargo", nullable = false, length = 255)
    @ApiModelProperty(value = "Cargo desempeñado en la experiencia", name = "cargo", required = true)
    private String cargo;

    @Column(name = "fecha_inicio", nullable = false)
    @ApiModelProperty(value = "Fecha de inicio de la experiencia", name = "fechaInicio", required = true, example = "2020-01-01")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    @ApiModelProperty(value = "Fecha de fin de la experiencia", name = "fechaFin", example = "2023-12-31")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaFin;

    @Column(name = "descripcion", length = 500)
    @ApiModelProperty(value = "Descripción detallada de la experiencia", name = "descripcion")
    private String descripcion;

    @Column(name = "tecnologias_herramientas", length = 500)
    @ApiModelProperty(value = "Tecnologías y herramientas utilizadas en la experiencia", name = "tecnologiasHerramientas")
    private String tecnologiasHerramientas;

}
