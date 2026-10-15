package com.example.app_demo_backend.Entidades;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class AlmacenProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAlmacen;

    private String codigoAlmacen;

    //Uno a Muchos
    //Una categoria tiene varios productos
    @OneToMany(mappedBy = "almacen")
    private List<Producto> productos;
}