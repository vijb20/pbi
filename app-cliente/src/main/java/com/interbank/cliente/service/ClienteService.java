package com.interbank.cliente.service;

import java.util.Optional;

import com.interbank.cliente.dto.ClienteDTO;
import com.interbank.cliente.exception.DatabaseException;
import com.interbank.cliente.http.response.ProductosByClienteResponse;

public interface ClienteService {
    Optional<ClienteDTO> obtenerClienteById(Long id) throws DatabaseException;
    Iterable<ClienteDTO> obtenerClientes() throws DatabaseException;
    Optional<ClienteDTO> obtenerClienteByNumeroDocumento(String numeroDocumento) throws DatabaseException;
    void agregarCliente(ClienteDTO cliente) throws DatabaseException;
    Optional<ClienteDTO> actualizarCliente(ClienteDTO cliente) throws DatabaseException;
    boolean eliminarcliente(Long id) throws DatabaseException;
    
    ProductosByClienteResponse obtenerProductosByCliente(Long clienteId) throws DatabaseException;
}
