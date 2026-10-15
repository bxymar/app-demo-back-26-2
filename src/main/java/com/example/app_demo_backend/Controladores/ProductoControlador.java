package com.example.app_demo_backend.Controladores;

import com.example.app_demo_backend.Dto.ProductoListarNombrePrecio;
import com.example.app_demo_backend.Entidades.Producto;
import com.example.app_demo_backend.Servicios.ProductoServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/productos/")
@CrossOrigin
public class ProductoControlador {

    private final ProductoServicio productoServicio;

    // Funcion para que el cliente pueda obtener los datos
    @GetMapping("listar")
    public ResponseEntity<List<Producto>> listarProductosController(){
        return ResponseEntity.ok(productoServicio.listarProductosService());
    }

    // Cliente: Angular -> Informacion
    // que manda es en formato JSON

    // @RequestBody los usamos para recepcionar la informacion
    // que llega desde el cliente.

    @PostMapping("crear")
    public ResponseEntity<Producto> crearProductoController(
            @RequestBody Producto producto
    ){
        return ResponseEntity.ok(
                productoServicio.crearProductoService(producto));
    }

    // Para la actualizacion de una entidad, necesitamos obtener
    // dicha entidad por id, obtendremos el id por la url
    @PutMapping("actualizar/{idProducto}")
    public ResponseEntity<Producto> actualizarProductoControlador(
            // @PathVariable, valor que
            // necesita la url (id para buscar el producto)
            @PathVariable Long idProducto,

            // Datos del producto para actualizar.
            @RequestBody Producto producto
    ){
        return ResponseEntity.ok(productoServicio
                .actualizarProductoService(idProducto, producto));
    }

    // Tipos de estados
    // => Respuestas satisfactorias
    // - 200 OK: La solicitud ha tenido exito
    // - 201 Created: La petición tuvo exito y se creó un nuevo recurso
    // - 204 No Content: La petición se proceso con
    // éxito pero no devuelve un contenido

    // => Errores de Cliente (Angular - Postman)
    // - 400 Bad Request: La petición tiene una sintaxis invalida o no se puede procesar
        // JSON Incorrecto, clave o valor invalido, o los valores agregados no cumplen las validaciones
    // - 401 Unauthorized: Falta autenticacion valida para acceder al recurso.
        // nombre de usuario o contraseña incorrectas,
        // (Solo aplica cuando se tenga autenticacion de usuario en el sistema)
    // - 404 Not Found: No se encontró el recurso o la página solicitada.

    // => Errores del servidor (Spring Boot)
    // - 500: Error generico en el servidor
        // - El servidor lanza alguna excepcion en caso de de haber agregado validaciones
    // - 501: El servidor no soporta la funcionalidad necesaria para responder

    // Funcion (controlador) para listar solo los nombres de todos los productos
    @GetMapping("listar-nombres")
    public ResponseEntity<List<String>> listarNombresProductosControlador(){
        return ResponseEntity.ok(productoServicio.listarNombresProductosService());
    }

    // Funcion (controlador) para listar todos los nombres y precios de todos los productos
    @GetMapping("listar-nombre-precio")
    public ResponseEntity<List<ProductoListarNombrePrecio>> listarNombrePrecioProductoControlador(){
        return ResponseEntity.ok(productoServicio.listarNombrePrecioProductoService());
    }
}