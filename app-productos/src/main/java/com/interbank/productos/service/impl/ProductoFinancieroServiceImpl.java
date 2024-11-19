package com.interbank.productos.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interbank.productos.dto.ProductoFinancieroDTO;
import com.interbank.productos.exception.DatabaseException;
import com.interbank.productos.mapper.ProductoFinancieroMapper;
import com.interbank.productos.model.ProductoFinanciero;
import com.interbank.productos.repository.ProductoFinancieroRepository;
import com.interbank.productos.service.ProductoFinancieroService;

@Service
public class ProductoFinancieroServiceImpl implements ProductoFinancieroService {
	
	@Autowired
	private ProductoFinancieroRepository financieroRepository;
	
	@Autowired
	private ProductoFinancieroMapper productoFinancieroMapper;

	@Override
	public Optional<ProductoFinancieroDTO> obtenerProductoFinanciero(Long id) throws DatabaseException {
		return financieroRepository.findById(id)
				.map(productoFinancieroMapper::toDTO);
	}

	@Override
	public Iterable<ProductoFinancieroDTO> obtenerProductoFinanciero() throws DatabaseException {
		return productoFinancieroMapper.toDtoIterable(financieroRepository.findAll());
	}

	@Override
	public Iterable<ProductoFinancieroDTO> obtenerProductoFinancieroClienteId(Long id) throws DatabaseException {
		return productoFinancieroMapper.toDtoIterable(financieroRepository.findAllByClienteId(id));
	}

	@Override
	public void agregarPedido(ProductoFinancieroDTO productoFinanciero) throws DatabaseException {
		financieroRepository.save(productoFinancieroMapper.toEntity(productoFinanciero));
	}

	@Override
	public Optional<ProductoFinancieroDTO> actualizarPedido(ProductoFinancieroDTO productoFinanciero) throws DatabaseException {
		return Optional.ofNullable(productoFinanciero)
				.filter(pr -> obtenerProductoFinanciero(pr.getId()).isPresent())
				.map(productoFinancieroDTO1 ->productoFinancieroMapper.toDTO(financieroRepository.save(productoFinancieroMapper.toEntity(productoFinancieroDTO1))));
	}

	@Override
	public boolean eliminarProductoFinanciero(Long id) throws DatabaseException {
		Optional<ProductoFinanciero> ProductoFinanciero= financieroRepository.findById(id);
		ProductoFinanciero.ifPresent(p -> financieroRepository.deleteById(id));		
		return ProductoFinanciero.isPresent();
	}

}
