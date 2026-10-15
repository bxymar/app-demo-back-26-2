package com.example.app_demo_backend.Repositorios;
import com.example.app_demo_backend.Dto.ProductoListarNombrePrecio;
import com.example.app_demo_backend.Entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductoRepositorio extends JpaRepository<Producto, Long> {

    // Para crear consultas se usa JPQL no se usa el lenguaje tradicional SQL
    // Agregar la anotacion @Query

    // Consulta para obtener todos los nombres de los productos
    @Query("""
            SELECT
            p.nombre
            FROM Producto p
            """)

    // Este debe retornar solamente el tipo de datos que es el campo nombre (String), ya que
    // Producto espera todas las propiedades que se definio en la capa de Entidades (Entity)
    List<String> listarNombresProductos();

    // Consulta para listar los nombres y precios de todos los productos
    @Query("""
            SELECT new com.example.app_demo_backend.Dto.ProductoListarNombrePrecio(
            p.nombre,
            p.precio
            )
            FROM Producto p
            """)
    List<ProductoListarNombrePrecio> listarProductoNombrePrecio();
}