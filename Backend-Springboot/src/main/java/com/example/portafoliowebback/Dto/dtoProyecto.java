package com.example.portafoliowebback.Dto;

import jakarta.validation.constraints.NotBlank;

public class dtoProyecto {

    @NotBlank
    private String link;
    @NotBlank
    private String descripcionP;

    public dtoProyecto() {
    }

    public dtoProyecto(String link, String descripcionP) {
        this.link = link;
        this.descripcionP = descripcionP;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescripcionP() {
        return descripcionP;
    }

    public void setDescripcionP(String descripcionP) {
        this.descripcionP = descripcionP;
    }
}
