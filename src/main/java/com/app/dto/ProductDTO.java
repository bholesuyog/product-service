package com.app.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public record ProductDTO(Long id, String name, String description, Double price, int stockQuantity, String category,
		String brand, String sku, String imageUrl, Double weight, String dimensions, String color, String size,
		String material, String manufacturer, String warrantyPeriod, Double discount, LocalDateTime releaseDate,
		Double rating, Integer reviewsCount, boolean active, LocalDateTime createdAt, LocalDateTime updatedAt,
		String createdBy, String updatedBy) {
}
