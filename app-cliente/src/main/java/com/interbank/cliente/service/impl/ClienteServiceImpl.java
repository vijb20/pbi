package com.interbank.cliente.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interbank.cliente.client.ProductoClient;
import com.interbank.cliente.dto.ClienteDTO;
import com.interbank.cliente.exception.DatabaseException;
import com.interbank.cliente.http.response.ProductosByClienteResponse;
import com.interbank.cliente.mapper.ClienteMapper;
import com.interbank.cliente.model.Cliente;
import com.interbank.cliente.repository.ClienteRepository;
import com.interbank.cliente.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteMapper clienteMapper;
	
	@Autowired
	private ProductoClient productoClient;
	
	@Override
	public Optional<ClienteDTO> obtenerClienteById(Long id) throws DatabaseException {
		return clienteRepository.findById(id)
				.map(clienteMapper::toDTO);
	}

	@Override
	public Iterable<ClienteDTO> obtenerClientes() throws DatabaseException {
		return clienteMapper.toDtoIterable(clienteRepository.findAll());
	}

	@Override
	public Optional<ClienteDTO> obtenerClienteByNumeroDocumento(String numeroDocumento) throws DatabaseException {
		return clienteRepository.findByNumeroDocumento(numeroDocumento)
				.map(clienteMapper::toDTO);
	}

	@Override
	public void agregarCliente(ClienteDTO cliente) throws DatabaseException {
		clienteRepository.save(clienteMapper.toEntity(cliente));		
	}

	@Override
	public Optional<ClienteDTO> actualizarCliente(ClienteDTO cliente) throws DatabaseException {
		return Optional.ofNullable(cliente)
				.filter(c -> obtenerClienteById(c.getId()).isPresent())
				.map(pdto -> clienteMapper.toDTO(clienteRepository.save(clienteMapper.toEntity(pdto))));
	}

	@Override
	public boolean eliminarcliente(Long id) throws DatabaseException {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		cliente.ifPresent(c -> clienteRepository.deleteById(id));
		return cliente.isPresent();
	}

	@Override
	public ProductosByClienteResponse obtenerProductosByCliente(Long clienteId) throws DatabaseException {
		
		return obtenerClienteById(clienteId)
				.map(c ->ProductosByClienteResponse.builder()
						.clienteDTO(c)
						.productos(productoClient.obtenerProductoFinancieroClienteId(clienteId))
						.build())
				.orElseGet(()-> new ProductosByClienteResponse());
	}

}
