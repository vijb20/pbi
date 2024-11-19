package com.interbank.cliente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interbank.cliente.service.ClienteService;

@RestController
@RequestMapping("api/cliente")
public class ClienteController {

	@Autowired
	private ClienteService service;
	
	@GetMapping("/numeroDocumento/{numeroDocumento}")
	public ResponseEntity<?> obtenerClienteByNumeroDocumento(@PathVariable String numeroDocumento){
		return service.obtenerClienteByNumeroDocumento(numeroDocumento)
				 .map(ResponseEntity::ok)
	                .orElseGet(() -> ResponseEntity.notFound().build());
	}	
	
	@GetMapping("/producto/{clienteId}")
	public ResponseEntity<?> obtenerProductoByCliente(@PathVariable Long clienteId){
	return	ResponseEntity.ok(service.obtenerProductosByCliente(clienteId));
	}
}
