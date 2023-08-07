package com.example.portafoliowebback.Security.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Column(unique = true)
    private String usuario;
    @NotNull
    private String nombreUsuario;
    @NotNull
    private String email;
    @NotNull
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> roles = new HashSet<>();

    public Usuario() {
    }

    public Usuario(int id, String usuario, String nombreUsuario, String email, String password, Set<Rol> roles) {
        this.id = id;
        this.usuario = usuario;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
}
