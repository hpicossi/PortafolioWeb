package com.example.portafoliowebback.Dto;

import jakarta.validation.constraints.NotBlank;

public class dtoHabilidad {

    @NotBlank
    private String nombreH;

    public dtoHabilidad() {
    }

    public dtoHabilidad(String nombreH) {
        this.nombreH = nombreH;
    }

    public String getNombreH() {
        return nombreH;
    }

    public void setNombreH(String nombreH) {
        this.nombreH = nombreH;
    }
}
