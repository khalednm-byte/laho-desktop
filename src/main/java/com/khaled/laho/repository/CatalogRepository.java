package com.khaled.laho.repository;

import java.util.List;

import com.khaled.laho.model.Game;

public interface CatalogRepository {

    List<Game> findAll();

}