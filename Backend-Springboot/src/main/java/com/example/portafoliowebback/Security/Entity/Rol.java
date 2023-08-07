package com.example.portafoliowebback.Security.Entity;

import com.example.portafoliowebback.Security.Enums.RolNombre;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Enumerated(EnumType.STRING)
    private RolNombre rolNombre;

    public Rol() {
    }

    public Rol(int id, RolNombre rolNombre) {
        this.id = id;
        this.rolNombre = rolNombre;
    }
}