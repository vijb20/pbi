package com.interbank.productos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductoFinancieroDTO {
	private Long id;
    private String tipoProducto;
    private String nombre;
    private Double saldo;
    private Long clienteId;
}
