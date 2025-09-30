package com.nicolas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nicolas.models.Artista;
import com.nicolas.repositories.RepositorioArtistas;

@Service
public class ServicioArtistas {
    
    @Autowired
    private final RepositorioArtistas repositorioArtistas;

    public ServicioArtistas(RepositorioArtistas repositorioArtistas){
        this.repositorioArtistas = repositorioArtistas;
    }

    public List<Artista> obtenerArtistas(){
        return this.repositorioArtistas.findAll();
    }

    public Artista obtenerArtistaId(Long id){
        return this.repositorioArtistas.findById(id).orElse(null);
    }

    public Artista agregarArtista(Artista nuevoArtista){
        return this.repositorioArtistas.save(nuevoArtista);
    }

}
