package com.example.portafoliowebback.Dto;

import jakarta.validation.constraints.NotBlank;

public class dtoExperiencia {

    @NotBlank
    private String nombreExp;
    @NotBlank
    private String nombreEmpresaExp;
    @NotBlank
    private String descripcionExp;
    @NotBlank
    private String aptitudesExp;

    public dtoExperiencia() {
    }

    public dtoExperiencia(String nombreExp, String nombreEmpresaExp, String descripcionExp, String aptitudesExp) {
        this.nombreExp = nombreExp;
        this.nombreEmpresaExp = nombreEmpresaExp;
        this.descripcionExp = descripcionExp;
        this.aptitudesExp = aptitudesExp;
    }

    public String getNombreExp() {
        return nombreExp;
    }

    public void setNombreExp(String nombreExp) {
        this.nombreExp = nombreExp;
    }

    public String getNombreEmpresaExp() {
        return nombreEmpresaExp;
    }

    public void setNombreEmpresaExp(String nombreEmpresaExp) {
        this.nombreEmpresaExp = nombreEmpresaExp;
    }

    public String getDescripcionExp() {
        return descripcionExp;
    }

    public void setDescripcionExp(String descripcionExp) {
        this.descripcionExp = descripcionExp;
    }

    public String getAptitudesExp() {
        return aptitudesExp;
    }

    public void setAptitudesExp(String aptitudesExp) {
        this.aptitudesExp = aptitudesExp;
    }
}
