package com.khaled.laho.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class Game {

	private UUID id;
	private String title; // Game title
	private String coverImageUrl; // Main cover
	private List<String> screenshots; // Gameplay images
	private String description; // Description (bio/summary)
	private double size; // Game size in GB
	private Set<GameGenre> genres; // e.g., RPG, Shooter
	private Set<GameFeatures> features; // e.g., Single Player, Online
	private BigDecimal price; // Price in USD (or local currency)

	// Constructor
	public Game(UUID id, String title, String coverImageUrl, String description, double size, Set<GameGenre> genres, Set<GameFeatures> features,
			BigDecimal price, List<String> screenshots) {
		this.id = id;
		this.title = title;
		this.coverImageUrl = coverImageUrl;
		this.description = description;
		this.size = size;
		this.genres = Set.copyOf(genres);
		this.features = Set.copyOf(features);
		this.price = price;
		this.screenshots = List.copyOf(screenshots);
	}

	// Getters & Setters
	public UUID getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCoverImageUrl() {
		return coverImageUrl;
	}

	public void setCoverImageUrl(String coverImageUrl) {
		this.coverImageUrl = coverImageUrl;
	}

	
	public List<String> getScreenshots() {
		return List.copyOf(screenshots);
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public Set<GameGenre> getGenres() {
		return genres;
	}

	public void setGenres(Set<GameGenre> genres) {
		this.genres = Set.copyOf(genres);
	}

	public Set<GameFeatures> getFeatures() {
		return features;
	}

	public void setFeatures(Set<GameFeatures> features) {
		this.features = Set.copyOf(features);
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Game{" + "title='" + title + '\'' + ", genres='" + genres + '\'' + ", features='" + features + '\'' + ", size="
				+ size + "GB" + ", price=" + price + '}';
	}
}
