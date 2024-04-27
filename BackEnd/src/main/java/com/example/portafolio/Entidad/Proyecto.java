package com.example.portafolio.Entidad;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "proyecto")
@ApiModel(value = "Entidad Proyecto", description = "Representa un proyecto del usuario")
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "ID único del proyecto", name = "idProyecto")
    private Long id;

    @ApiModelProperty(value = "Nombre del proyecto", name = "nombre", required = true)
    private String nombre;

    @Lob
    @Column(nullable = true)
    @ApiModelProperty(value = "Imagen del proyecto en formato JPEG", name = "imagen")
    private byte[] imagen;

    @ApiModelProperty(value = "Descripción del proyecto", name = "descripcion")
    private String descripcion;

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public byte[] getImagen() {
        return imagen;
    }
}
