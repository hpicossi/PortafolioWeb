package com.example.portafolio.Entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.Set;

@Entity
@Getter
@Setter
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(length = 500)
    private String descripcion;

    @Column(nullable = false)
    private Date fechaInicio;

    @Column(nullable = false)
    private Date fechaFin;

    @Column(length = 500)
    private String enlaces;

    @Lob
    private byte[] imagen;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "proyecto_tecnologias",
            joinColumns = @JoinColumn(name = "proyecto_id"),
            inverseJoinColumns = @JoinColumn(name = "tecnologia_id"))
    private Set<Tecnologia> tecnologias;

    @ManyToOne
    @JoinColumn(name = "acerca_de_mi_id")
    private AcercaDeMi acercaDeMi;

}