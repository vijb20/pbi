package com.interbank.productos.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.interbank.productos.dto.ProductoFinancieroDTO;
import com.interbank.productos.model.ProductoFinanciero;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductoFinancieroMapper {
	ProductoFinancieroDTO toDTO(ProductoFinanciero productoFinanciero);

	ProductoFinanciero toEntity(ProductoFinancieroDTO productoFinancieroDTO);

	Iterable<ProductoFinancieroDTO> toDtoIterable(Iterable<ProductoFinanciero> productoFinanciero);

	Iterable<ProductoFinanciero> toEntityIterable(Iterable<ProductoFinancieroDTO> productoFinancieroDTO);
}
