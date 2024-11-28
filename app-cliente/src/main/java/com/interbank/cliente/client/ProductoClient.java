package com.interbank.cliente.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.interbank.cliente.dto.ProductoFinancieroDTO;

@FeignClient(name = "app-productos")
public interface ProductoClient {
	@GetMapping("/api/producto/cliente/{idCliente}")
	Iterable<ProductoFinancieroDTO> obtenerProductoFinancieroClienteId(@PathVariable Long idCliente);

}
