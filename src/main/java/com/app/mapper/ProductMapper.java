package com.app.mapper;

import org.mapstruct.Mapper;

import com.app.dto.ProductDTO;
import com.app.entity.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {

	ProductDTO toDto(Product product);

	Product toEntity(ProductDTO productDTO);
}
