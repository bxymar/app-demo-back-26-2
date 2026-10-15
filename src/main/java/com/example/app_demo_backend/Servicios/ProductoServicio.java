package com.example.app_demo_backend.Servicios;

import com.example.app_demo_backend.Dto.ProductoListarNombrePrecio;
import com.example.app_demo_backend.Entidades.Producto;
import com.example.app_demo_backend.Repositorios.ProductoRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoServicio {

    private final ProductoRepositorio productoRepositorio;

    // Funciones para vincular con las consultas SQL (funciones predefinidas)

    // Funcion para listar a todos los productos
    public List<Producto> listarProductosService(){
        // El findAll(), obtiene los columnas de una tabla
        return productoRepositorio.findAll();
    }

    // Funcion para crear un nuevo producto
    public Producto crearProductoService(Producto producto){

        // Validar datos (Manejo de Excepciones)
        if (producto.getNombre() == null || producto.getNombre().isBlank() || producto.getNombre().length() < 3){
            throw new IllegalArgumentException("Nombre invalido");
        }

        // Validar el precio del producto
        if (producto.getPrecio() == null || producto.getPrecio() <= 0){
            throw new IllegalArgumentException("Precio invalido");
        }

        // Validar el estado del producto
        if (producto.getEstado() == null){
            producto.setEstado(true);
        }

        return productoRepositorio.save(producto);
    }

    // Función para actualizar los datos de un producto
    // idProducto, sirve para buscar el producto que deseamos actualizar
    // producto, carga los datos actuales del producto
    public Producto actualizarProductoService(Long idProducto,
                                              Producto producto){
        // Buscar el producto (idProducto)
        Producto productoEncontrado = productoRepositorio
                .findById(idProducto)
                // En caso de no encontrar un
                // producto por id, lanzamos una excepción
                .orElseThrow(() ->
                        new IllegalArgumentException("No se encontro el producto"));

        // Actualizamos los campos del producto
        productoEncontrado.setNombre(producto.getNombre());
        productoEncontrado.setPrecio(producto.getPrecio());
        productoEncontrado.setEstado(producto.getEstado());

        // En caso de que se encuentre un producto con el id, guardamos (actualizamos)
        // el producto
        return productoRepositorio.save(productoEncontrado);
    }

    // Funcion (servicio) para listar solo nombres de todos los productos
    public List<String> listarNombresProductosService(){
        return productoRepositorio.listarNombresProductos();
    }

    // Funcion (servicio) para listar los nombres y precios de todos mis productos
    public List<ProductoListarNombrePrecio> listarNombrePrecioProductoService(){
        return productoRepositorio.listarProductoNombrePrecio();
    }
}