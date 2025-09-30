package com.nicolas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nicolas.models.Artista;

@Repository
public interface RepositorioArtistas extends CrudRepository<Artista, Long> {

    List<Artista>findAll();
    

    Artista save(Artista nuevoArtista);
} 