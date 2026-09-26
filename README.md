# Laho Desktop

Laho Desktop is a JavaFX game storefront and launcher prototype built as a portfolio-quality desktop application. The project focuses on clean architecture, local catalog browsing, simulated purchases, persistent libraries, and eventually safe game installation and launching.

> **Project status:** Milestone 1 is in progress. The FXML application shell displays a local JSON catalog in a basic Store view, with catalog loading covered by automated tests. The Library remains a placeholder; game details, search, purchasing, and ownership persistence are still planned.

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
- JavaFX 21 with FXML
- Gradle 8.9 via the Gradle Wrapper
- JUnit 5
- Jackson Databind

### Planned for the offline milestone

- JavaFX CSS
- SQLite JDBC

## Architecture

The target architecture for the completed offline milestone is:

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

The current implementation has these responsibilities:

```text
app/          Startup and connecting the repository to the UI
controller/   FXML interaction, shell navigation, and game display
model/        Domain models and enums
repository/   Catalog contract and JSON loading
```

Java packages live under `src/main/java/com/khaled/laho`. FXML views and the catalog are under `src/main/resources/com/khaled/laho`, in `fxml/` and `data/` respectively. Tests live under `src/test/java`, with test-only data under `src/test/resources`.

The `service/`, `navigation/`, and `persistence/` packages are planned and will be introduced as their responsibilities become necessary. Navigation currently lives in `AppShellController`; JSON parsing currently lives in `JsonCatalogRepository`.

Controllers should remain thin. Purchasing, persistence, file handling, downloading, and game-launching logic belong in services and repositories rather than JavaFX event handlers.

## Current State

The early login form has been replaced by an FXML application shell with Store and Library buttons. The Store is shown on startup and displays each game's title, price, and description. Switching to Library shows a placeholder; switching back restores the existing Store view without reading the catalog again.

The current catalog contains one fictional game, **Royal Blood**, in `src/main/resources/com/khaled/laho/data/game.json`. Cover art and screenshots are not displayed yet.

The `Game` model has final fields, constructor-provided UUIDs, `BigDecimal` prices, `GameGenre` and `GameFeature` enum sets, and defensive collection copies. Jackson constructor annotations map JSON fields to these values. Catalog UUIDs are stored in JSON and preserved when games are loaded.

`CatalogRepository` defines `findAll()`. `JsonCatalogRepository` implements it using Jackson, closes the input stream automatically, and throws descriptive exceptions for missing resources or unreadable/invalid JSON.

At startup:

1. `Main` creates the catalog repository and loads `app-shell.fxml`.
2. The repository reads the catalog and returns a `List<Game>`.
3. `Main` passes that list to `AppShellController.loadStore()`.
4. The shell loads `store.fxml` and passes the games to its `StoreController`.
5. `StoreController.displayGames()` creates labels for each game, and the shell displays the populated Store view.

Three JUnit tests cover successful loading, a missing resource, and malformed JSON. The successful-loading test checks the title, UUID, price, genres, and features. These tests cover the repository; automated UI and library tests are not implemented yet.

`Customer`, `Developer`, and the model class `Store` remain early placeholders and do not implement purchasing or ownership. There is no SQLite database or persistent library yet.

The next development focus is reusable game entries and a game-details view, building on the working catalog-to-Store flow.

## Getting Started

### Requirements

- JDK 21

The project uses the Gradle Wrapper, so a separate Gradle installation is not required. Run the commands below from the project root. The first build needs access to download Gradle and dependencies; the application's catalog data is local.

### Windows PowerShell

Run the application:

```powershell
.\gradlew.bat run
```

Run the tests:

```powershell
.\gradlew.bat test
```

Build the project:

```powershell
.\gradlew.bat build
```

### Git Bash, Linux, and macOS

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
./gradlew build
```

### Optional project-local Gradle cache

If the default Gradle cache location is not writable, use the ignored `.gradle-user-home` directory inside the project:

```powershell
.\gradlew.bat --gradle-user-home .gradle-user-home test
```

In Git Bash, Linux, or macOS:

```bash
./gradlew --gradle-user-home .gradle-user-home test
```

The same option can be used with `run` or `build`. This cache is local tooling data and is excluded from Git.

## Roadmap

### Milestone 1 — Offline Storefront

- [x] Clean and reorganize the project
- [x] Establish startup, controller, model, and repository packages
- [x] Introduce the FXML shell and basic Store/Library navigation
- [x] Create the immutable game catalog model
- [x] Add genre and feature enums
- [x] Load the local fictional game catalog from JSON
- [x] Display game titles, prices, and descriptions in a basic Store view
- [x] Test catalog loading, missing resources, and malformed JSON
- [ ] Introduce service, navigation, and persistence packages as needed
- [ ] Build reusable game cards
- [ ] Add a game-details screen and navigation from the Store
- [ ] Add search, filtering, and sorting
- [ ] Add simulated purchasing
- [ ] Replace the Library placeholder with an owned-games screen
- [ ] Persist ownership records with SQLite
- [ ] Add tests for search, purchasing, library behavior, and ownership persistence
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
