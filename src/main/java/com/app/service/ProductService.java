package com.app.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.dto.ProductDTO;
import com.app.entity.Product;
import com.app.mapper.ProductMapper;
import com.app.messaging.EventPublisher;
import com.app.messaging.events.CreateProductEvent;
import com.app.messaging.events.UpdateProductEvent;
import com.app.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductService {

	private ProductRepository productRepository;

	private ProductMapper productMapper;

	private EventPublisher eventPublisher;

	public ProductService(ProductRepository productRepository, ProductMapper productMapper,
			EventPublisher eventPublisher) {
		super();
		this.productRepository = productRepository;
		this.productMapper = productMapper;
		this.eventPublisher = eventPublisher;
	}

	public ProductDTO createProduct(ProductDTO productDTO) {
		Product product = productMapper.toEntity(productDTO);
		product.setCreatedBy("USER");
		return productMapper.toDto(productRepository.save(product));
	}

	public void createProductEvent(ProductDTO productDTO) {
		final var event = CreateProductEvent.builder().productDTO(productDTO).build();
		
		eventPublisher.publish(event);
	}

	public void updateProductEvent(Long id, ProductDTO productDTO) {
		final var event = UpdateProductEvent.builder().productDTO(productDTO).build();
		eventPublisher.publish(event);
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