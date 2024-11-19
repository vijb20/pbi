package com.interbank.cliente.http.response;

import com.interbank.cliente.dto.ClienteDTO;
import com.interbank.cliente.dto.ProductoFinancieroDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductosByClienteResponse {
	
    private ClienteDTO clienteDTO;
	private Iterable<ProductoFinancieroDTO> productos;

}
