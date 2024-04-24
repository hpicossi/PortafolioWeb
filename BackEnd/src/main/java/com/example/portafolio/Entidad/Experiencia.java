package com.example.portafolio.Entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.Set;

@Entity
@Getter
@Setter
public class Experiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombreEmpresa;

    @Column(nullable = false)
    private String cargo;

    @Column(length = 500)
    private String descripcion;

    @Column(nullable = false)
    private Date fechaInicio;

    @Column(nullable = false)
    private Date fechaFin;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "experiencia_tecnologias",
            joinColumns = @JoinColumn(name = "experiencia_id"),
            inverseJoinColumns = @JoinColumn(name = "tecnologia_id"))
    private Set<Tecnologia> tecnologias;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "experiencia_conocimientos",
            joinColumns = @JoinColumn(name = "experiencia_id"),
            inverseJoinColumns = @JoinColumn(name = "conocimiento_id"))
    private Set<Conocimiento> conocimientos;

}
