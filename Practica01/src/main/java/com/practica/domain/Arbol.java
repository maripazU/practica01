package com.practica.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;


@Data 
@Entity 
@Table(name="arbol") 
public class Arbol implements Serializable{ 
    private static final long serialVersionUID=1L; 
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name="id_arbol") 
    private long idArbol;
    private String nombre;
    private String tipoFlor;
    private String dureza;
    private String descripcion;
    private String rutaImagen;
    private boolean activo;
}
