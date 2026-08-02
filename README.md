# Laho Desktop

Laho Desktop is a JavaFX game storefront and launcher prototype built as a portfolio-quality desktop application. The project focuses on clean architecture, local catalog browsing, simulated purchases, persistent libraries, and eventually safe game installation and launching.

> **Project status:** Early development. Repository cleanup and Git setup are complete, and the application structure is now being standardized before the main storefront features are implemented.

## Current Goal

Build a fully offline desktop experience where a user can:

1. Browse a local game catalog.
2. Search, filter, and sort games.
3. Open a game-details page.
4. Perform a simulated purchase.
5. View purchased games in a library.
6. Close and reopen the application without losing ownership data.

## Planned Features

- Store and Library pages
- Reusable game cards
- Real-time title search
- Genre filters
- Title and price sorting
- Game-details pages
- Simulated purchasing
- Persistent ownership records
- Local JSON game catalog
- SQLite persistence
- Install, Play, and Uninstall states
- Download progress and ZIP extraction
- SHA-256 package verification
- Trusted executable launching

## Technology

### Current

- Java 21
- JavaFX 21
- Gradle Wrapper
- JUnit 5

### Planned for the offline milestone

- JavaFX FXML
- JavaFX CSS
- Jackson Databind
- SQLite JDBC

## Architecture

The application is being organized around the following flow:

```text
JavaFX Views and FXML
        ↓
Controllers
        ↓
Services
        ↓
Repositories
        ↓
JSON and SQLite
```

Planned responsibilities include:

```text
app/          Application startup
controller/   JavaFX events and screen state
model/        Domain models and enums
service/      Application behavior
repository/   Data-access contracts and implementations
navigation/   Screen navigation
persistence/  JSON, SQLite, and local storage support
resources/    FXML, CSS, JSON, and images
```

Controllers should remain thin. Purchasing, persistence, file handling, downloading, and game-launching logic belong in services and repositories rather than JavaFX event handlers.

## Current State

The repository contains an early JavaFX login interface and initial domain classes such as `Game`, `Customer`, `Developer`, `Store`, and `GameFilters`.

Git setup, repository cleanup, the Gradle wrapper, and the move toward the `com.khaled.laho` package are complete or underway. The next step is to finish the application package structure and replace the early interface with an FXML-based application shell.

## Getting Started

### Requirements

- JDK 21

The project uses the Gradle Wrapper, so a separate Gradle installation is not required.

### Linux and macOS

Run the application:

```bash
./gradlew run
```

Run the tests:

```bash
./gradlew test
```

Build the project:

```bash
gradle build
```

## Roadmap

### Milestone 1 — Offline Storefront

- [x] Clean and reorganize the project
- [ ] Create the application package structure
- [ ] Introduce FXML views and navigation
- [ ] Improve the game domain model
- [ ] Add genre and feature enums
- [ ] Load fictional games from JSON
- [ ] Build Store and game-details screens
- [ ] Add search, filtering, and sorting
- [ ] Add simulated purchasing
- [ ] Build the Library screen
- [ ] Persist ownership records with SQLite
- [ ] Add tests for catalog and library behavior
- [ ] Improve styling after the complete flow works

### Milestone 2 — Desktop Launcher

- [ ] Track installed games
- [ ] Download trusted game packages
- [ ] Show download progress
- [ ] Verify SHA-256 hashes
- [ ] Extract ZIP packages safely
- [ ] Add Install, Play, and Uninstall actions
- [ ] Launch trusted executables
- [ ] Track versions and last-played dates

### Milestone 3 — Optional Online Services

A future version may use Spring Boot, PostgreSQL, authentication, object storage, and downloadable manifests. These features will only be considered after the offline application is stable.

## Project Principles

- Complete one working milestone at a time.
- Prioritize maintainable architecture over unnecessary frameworks.
- Keep business logic separate from the JavaFX interface.
- Finish functionality before advanced styling and animation.
- Use trusted, validated metadata for downloads and executable launching.

## Disclaimer

Laho Desktop is an independent educational and portfolio project inspired by desktop game storefronts. It is not affiliated with, endorsed by, or intended to reproduce the complete Steam platform.
