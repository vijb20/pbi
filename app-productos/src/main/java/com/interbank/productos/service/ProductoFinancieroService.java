package com.interbank.productos.service;

import java.util.Optional;

import com.interbank.productos.dto.ProductoFinancieroDTO;
import com.interbank.productos.exception.DatabaseException;

public interface ProductoFinancieroService {
    Optional<ProductoFinancieroDTO> obtenerProductoFinanciero(Long id) throws DatabaseException;
    Iterable<ProductoFinancieroDTO> obtenerProductoFinanciero() throws DatabaseException;
    Iterable<ProductoFinancieroDTO> obtenerProductoFinancieroClienteId(Long id) throws DatabaseException;
    void agregarPedido(ProductoFinancieroDTO productoFinanciero) throws DatabaseException;
    Optional<ProductoFinancieroDTO> actualizarPedido(ProductoFinancieroDTO	 productoFinanciero) throws DatabaseException;
    boolean eliminarProductoFinanciero(Long id) throws DatabaseException;
}
