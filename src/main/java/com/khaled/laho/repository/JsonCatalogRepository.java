package com.khaled.laho.repository;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.khaled.laho.model.Game;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.core.type.TypeReference;

public class JsonCatalogRepository implements CatalogRepository{
	
	private final ObjectMapper objectMapper;
	private final String resourcePath; 
	
	public JsonCatalogRepository(ObjectMapper objectMapper, String resourcePath) {
		this.objectMapper = objectMapper;
		this.resourcePath = resourcePath;
	}
	
	@Override
	public List<Game> findAll() {
	    try (InputStream input =
	                 JsonCatalogRepository.class.getResourceAsStream(resourcePath)) {

	        if (input == null) {
	            throw new IllegalStateException(
	                    "Catalog resource not found: " + resourcePath
	            );
	        }

	        return objectMapper.readValue(
	                input,
	                new TypeReference<List<Game>>() {}
	        );

	    } catch (IOException e) {
	        throw new IllegalStateException(
	                "Could not read catalog: " + resourcePath,
	                e
	        );
	    }
	}

}
