package com.example.portafolio.Entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Getter
@Setter
@Table(name = "experiencia")
public class Experiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_empresa", nullable = false, length = 255)
    private String nombreEmpresa;

    @Column(name = "cargo", nullable = false, length = 255)
    private String cargo;

    @Column(name = "fecha_inicio", nullable = false)
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    private Date fechaFin;

    @Column(name = "descripcion", length = 500)
    private String descripcion;

    @Column(name = "tecnologias_herramientas", length = 500)
    private String tecnologiasHerramientas;

}
