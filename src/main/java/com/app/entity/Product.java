package com.app.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(length = 500)
	private String description;

	@Column(nullable = false)
	private BigDecimal price;

	@Column(nullable = false)
	private int stockQuantity;

	@Column
	private String category;

	@Column
	private String brand;

	@Column
	private String sku;

	@Column
	private String imageUrl;

	@Column
	private Double weight;

	@Column
	private String dimensions;

	@Column
	private String color;

	@Column
	private String size;

	@Column
	private String material;

	@Column
	private String manufacturer;

	@Column
	private String warrantyPeriod;

	@Column
	private Double discount;

	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime releaseDate;

	@Column
	private Double rating;

	@Column
	private Integer reviewsCount;

	@Column
	private boolean active;

	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime updatedAt;

	@Column
	private String createdBy;

	@Column
	private String updatedBy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String getDimensions() {
		return dimensions;
	}

	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getWarrantyPeriod() {
		return warrantyPeriod;
	}

	public void setWarrantyPeriod(String warrantyPeriod) {
		this.warrantyPeriod = warrantyPeriod;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public LocalDateTime getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDateTime releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Integer getReviewsCount() {
		return reviewsCount;
	}

	public void setReviewsCount(Integer reviewsCount) {
		this.reviewsCount = reviewsCount;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Override
	public int hashCode() {
		return Objects.hash(active, brand, category, color, createdAt, createdBy, description, dimensions, discount, id,
				imageUrl, manufacturer, material, name, price, rating, releaseDate, reviewsCount, size, sku,
				stockQuantity, updatedAt, updatedBy, warrantyPeriod, weight);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return active == other.active && Objects.equals(brand, other.brand) && Objects.equals(category, other.category)
				&& Objects.equals(color, other.color) && Objects.equals(createdAt, other.createdAt)
				&& Objects.equals(createdBy, other.createdBy) && Objects.equals(description, other.description)
				&& Objects.equals(dimensions, other.dimensions) && Objects.equals(discount, other.discount)
				&& Objects.equals(id, other.id) && Objects.equals(imageUrl, other.imageUrl)
				&& Objects.equals(manufacturer, other.manufacturer) && Objects.equals(material, other.material)
				&& Objects.equals(name, other.name) && Objects.equals(price, other.price)
				&& Objects.equals(rating, other.rating) && Objects.equals(releaseDate, other.releaseDate)
				&& Objects.equals(reviewsCount, other.reviewsCount) && Objects.equals(size, other.size)
				&& Objects.equals(sku, other.sku) && stockQuantity == other.stockQuantity
				&& Objects.equals(updatedAt, other.updatedAt) && Objects.equals(updatedBy, other.updatedBy)
				&& Objects.equals(warrantyPeriod, other.warrantyPeriod) && Objects.equals(weight, other.weight);
	}

}
