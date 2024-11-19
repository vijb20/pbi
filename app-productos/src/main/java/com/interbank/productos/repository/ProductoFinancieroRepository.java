package com.interbank.productos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.interbank.productos.model.ProductoFinanciero;

public interface ProductoFinancieroRepository extends JpaRepository<ProductoFinanciero, Long>{
	List<ProductoFinanciero> findAllByClienteId(Long clienteId);
}
