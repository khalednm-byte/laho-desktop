package com.khaled.laho.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Game {

	private final UUID id;
	private final String title; // Game title
	private final String coverImageUrl; // Main cover
	private final List<String> screenshots; // Gameplay images
	private final String description; // Description (bio/summary)
	private final double sizeInGb; // Game size in GB
	private final Set<GameGenre> genres; // e.g., RPG, Shooter
	private final Set<GameFeature> features; // e.g., Single Player, Online
	private final BigDecimal price; // Price in USD (or local currency)

	// Constructor
	@JsonCreator
	public Game(
			@JsonProperty("id") UUID id, 
			@JsonProperty("title") String title, 
			@JsonProperty("coverImageUrl") String coverImageUrl, 
			@JsonProperty("description") String description, 
			@JsonProperty("sizeInGb") double sizeInGb, 
			@JsonProperty("genres") Set<GameGenre> genres, 
			@JsonProperty("features") Set<GameFeature> features,
			@JsonProperty("price") BigDecimal price, 
			@JsonProperty("screenshots") List<String> screenshots) {
		this.id = id;
		this.title = title;
		this.coverImageUrl = coverImageUrl;
		this.description = description;
		this.sizeInGb = sizeInGb;
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


	public String getCoverImageUrl() {
		return coverImageUrl;
	}

	
	public List<String> getScreenshots() {
		return screenshots;
	}


	public String getDescription() {
		return description;
	}


	public double getSizeInGb() {
		return sizeInGb;
	}


	public Set<GameGenre> getGenres() {
		return genres;
	}


	public Set<GameFeature> getFeatures() {
		return features;
	}


	public BigDecimal getPrice() {
		return price;
	}


	@Override
	public String toString() {
		return "Game{" + "title='" + title + '\'' + ", genres='" + genres + '\'' + ", features='" + features + '\'' + ", size (GB)="
				+ sizeInGb + "GB" + ", price=" + price + '}';
	}
}
