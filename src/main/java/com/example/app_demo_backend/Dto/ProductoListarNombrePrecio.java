package com.example.app_demo_backend.Dto;

// DTO, Viene de las siglas (Data Transfer Object) o
// traducido directamente como Objeto de Transferencia de datos, los dto's son clases
// especializadas solo para transportar informacion entre las diferentes capas, evitando
// filtrar datos sensibles de una entidad.

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductoListarNombrePrecio {
    // Definir solo aquellos atributos que necesitan ser listados
    private String nombre;
    private Double precio;
}