package com.khaled.laho.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.khaled.laho.model.Game;
import com.khaled.laho.model.GameFeature;
import com.khaled.laho.model.GameGenre;

class JsonCatalogRepositoryTest {

    @Test
    void loadsGamesFromJsonCatalog() {
        JsonCatalogRepository repository =
                new JsonCatalogRepository(
                        new ObjectMapper(),
                        "/com/khaled/laho/data/game.json"
                );

        List<Game> games = repository.findAll();

        assertEquals(1, games.size());

        Game game = games.get(0);

        assertEquals("Royal Blood", game.getTitle());
        assertEquals(new BigDecimal("24.99"), game.getPrice());
        assertEquals(UUID.fromString("c7da3444-7ad1-42b9-aa3d-24e102278b95"), game.getId());
        assertTrue(game.getGenres().contains(GameGenre.ADVENTURE));
        assertTrue(game.getGenres().contains(GameGenre.RPG));
        assertTrue(game.getFeatures().contains(GameFeature.SINGLE_PLAYER));
        
    }
    
    @Test
    void throwsWhenCatalogResourceIsMissing() {
    	JsonCatalogRepository repository = new JsonCatalogRepository(
    			new ObjectMapper(), 
    			"/com/khaled/laho/data/does-not-exist.json");
    	
    	assertThrows(IllegalStateException.class, () -> repository.findAll());
    }
    
    @Test
    void throwsWhenCatalogJsonIsMalformed() {
    	JsonCatalogRepository repository = new JsonCatalogRepository(
    			new ObjectMapper(), 
    			"/com/khaled/laho/data/malformed-game.json");
    	
    	assertThrows(IllegalStateException.class, () -> repository.findAll());
    }
    
}