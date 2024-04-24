package com.example.portafolio.Entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class AcercaDeMi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(length = 500)
    private String descripcion;

    @Column(length = 500)
    private String perfilProfesional;

    @OneToMany(mappedBy = "acercaDeMi")
    private List<Proyecto> proyectos;
}