package model;

import java.util.ArrayList;
import java.util.List;

public class Game {
    
    private String title;               // Game title
    private String coverImageUrl;       // Main cover
    private List<String> screenshots;   // Gameplay images
    private String description;         // Description (bio/summary)
    private double size;                // Game size in GB
    private String genre;               // e.g., RPG, Shooter
    private String type;                // e.g., Single Player, Online
    private double price;               // Price in USD (or local currency)

    // Constructor
    public Game(String title, String coverImageUrl, String description,
                double size, String genre, String type, double price) {
        this.title = title;
        this.coverImageUrl = coverImageUrl;
        this.description = description;
        this.size = size;
        this.genre = genre;
        this.type = type;
        this.price = price;
        this.screenshots = new ArrayList<>();
    }

    // Getters & Setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getCoverImageUrl() { return coverImageUrl; }
    public void setCoverImageUrl(String coverImageUrl) { this.coverImageUrl = coverImageUrl; }

    public List<String> getScreenshots() { return screenshots; }
    public void addScreenshot(String screenshotUrl) { this.screenshots.add(screenshotUrl); }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getSize() { return size; }
    public void setSize(double size) { this.size = size; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return "Game{" +
                "title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", type='" + type + '\'' +
                ", size=" + size + "GB" +
                ", price=" + price +
                '}';
    }
}
