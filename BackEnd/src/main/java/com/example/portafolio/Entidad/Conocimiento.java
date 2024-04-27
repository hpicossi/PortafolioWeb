package com.example.portafolio.Entidad;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "conocimiento")
@ApiModel(value = "Entidad Conocimiento", description = "Representa un conocimiento del usuario")
public class Conocimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "ID único del conocimiento", name = "idConocimiento")
    private Long id;

    @ApiModelProperty(value = "Nombre del conocimiento", name = "nombre")
    private String nombre;

    @Lob
    @Column(nullable = true)
    @ApiModelProperty(value = "Imagen del conocimiento en formato JPEG", name = "imagen")
    private byte[] imagen;

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public byte[] getImagen() {
        return imagen;
    }
}