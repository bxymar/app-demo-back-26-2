package com.example.app_demo_backend.Entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;
    private String nombre;
    private Double precio;
    private Boolean estado;

    // Relación Uno a Uno
    // Un producto tiene un detalle de producto
    @OneToOne
    @JoinColumn(name = "detalle_id")
    private DetalleProducto detalleProducto;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private AlmacenProducto almacen;
}