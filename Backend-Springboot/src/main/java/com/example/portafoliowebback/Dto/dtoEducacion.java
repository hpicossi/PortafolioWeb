package com.example.portafoliowebback.Dto;

import jakarta.validation.constraints.NotBlank;

public class dtoEducacion {
    @NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;

    @NotBlank
    private String actitudE;

    public dtoEducacion() {
    }

    public dtoEducacion(String nombreE, String descripcionE, String actitudE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.actitudE = actitudE;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }

    public String getActitudE() {
        return actitudE;
    }

    public void setActitudE(String actitudE) {
        this.actitudE = actitudE;
    }
}
