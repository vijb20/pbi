package com.interbank.cliente.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.interbank.cliente.dto.ClienteDTO;
import com.interbank.cliente.model.Cliente;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ClienteMapper {
    /**
    *
    * @param cliente
    * @return
    */
   ClienteDTO toDTO(Cliente cliente);

   /**
    *
    * @param clienteDTO
    * @return
    */
   Cliente toEntity(ClienteDTO clienteDTO);

   /**
    *
    * @param clientes
    * @return
    */
   Iterable<ClienteDTO> toDtoIterable(Iterable<Cliente> clientes);

   /**
    *
    * @param clienteDTOS
    * @return
    */
   Iterable<Cliente> toEntityIterable(Iterable<ClienteDTO> clienteDTOS);
}
