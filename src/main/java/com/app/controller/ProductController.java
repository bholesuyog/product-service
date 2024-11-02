package com.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ProductDTO;
import com.app.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	private ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@PostMapping("/publish")
	public ResponseEntity<String> createProductEvent(@RequestBody ProductDTO productDTO) {
		productService.createProductEvent(productDTO);
		return new ResponseEntity<>("Create Product message placed in queue.", HttpStatus.ACCEPTED);
	}

	@PutMapping("/publish/{id}")
	public ResponseEntity<String> updateProductEvent(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
		productService.updateProductEvent(id, productDTO);
		return new ResponseEntity<>("Update Product message placed in queue.", HttpStatus.ACCEPTED);
	}

	@PostMapping
	public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
		return new ResponseEntity<>(productService.createProduct(productDTO), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<ProductDTO>> getAllProducts() {
		return ResponseEntity.ok(productService.getAllProducts());
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
		return productService.getProductById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
		return new ResponseEntity<>(productService.updateProduct(id, productDTO), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/active")
	public ResponseEntity<List<ProductDTO>> getActiveProducts() {
		return ResponseEntity.ok(productService.getActiveProducts());
	}

}
