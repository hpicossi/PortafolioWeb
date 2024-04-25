package com.example.portafolio.Entidad;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "educacion")
public class Educacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_institucion", nullable = false, length = 255)
    private String nombreInstitucion;

    @Column(name = "titulo", nullable = false, length = 255)
    private String titulo;

    @Column(name = "fecha_inicio", nullable = false)
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    private Date fechaFin;

    @Column(name = "descripcion", length = 500)
    private String descripcion;

    // Getters, setters, constructors and other methods
}