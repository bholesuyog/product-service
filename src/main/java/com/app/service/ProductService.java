package com.app.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.ProductDTO;
import com.app.entity.Product;
import com.app.mapper.ProductMapper;
import com.app.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductMapper productMapper;

	public ProductDTO createProduct(ProductDTO productDTO) {
		Product product = productMapper.toEntity(productDTO);
		product.setCreatedBy("USER");
		return productMapper.toDto(productRepository.save(product));
		
		//add message to queue
		
		
	}

	public List<ProductDTO> getAllProducts() {
		return productRepository.findAll().stream().map(productMapper::toDto).toList();
	}

	public Optional<ProductDTO> getProductById(Long id) {
		return productRepository.findById(id).map(productMapper::toDto);
	}

	public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
		Product product = productMapper.toEntity(productDTO);
		product.setId(id);
		product.setUpdatedAt(LocalDateTime.now());
		product.setUpdatedBy("User1");
		return productMapper.toDto(productRepository.save(product));
	}

	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}

	public List<ProductDTO> getActiveProducts() {
		return productRepository.findAll().stream().filter(Product::isActive).map(productMapper::toDto).toList();
	}
}