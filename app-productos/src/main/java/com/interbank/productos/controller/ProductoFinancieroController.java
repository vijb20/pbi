package com.interbank.productos.controller;

import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interbank.productos.dto.ProductoFinancieroDTO;
import com.interbank.productos.service.ProductoFinancieroService;

@RestController
@RequestMapping("api/producto")
public class ProductoFinancieroController {

	@Autowired
	private ProductoFinancieroService service;
	
	@GetMapping("/cliente/{idCliente}")
	public ResponseEntity<?> obtenerProductoFinancieroClienteId(@PathVariable Long idCliente){
		Iterable<ProductoFinancieroDTO> productos = service.obtenerProductoFinancieroClienteId(idCliente);
		return StreamSupport.stream(productos.spliterator(), false)
				.findAny()
				.map(p -> ResponseEntity.ok(productos))// Si hay al menos un cliente, devuelve 200 OK
                .orElseGet(() -> ResponseEntity.noContent().build()); // Si no hay clientes, devuelve 204 No Content
	}
	
}
