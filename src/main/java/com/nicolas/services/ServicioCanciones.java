package com.nicolas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nicolas.models.Cancion;
import com.nicolas.repositories.RepositorioCanciones;

@Service
public class ServicioCanciones {
    @Autowired
    private final RepositorioCanciones repositorioCanciones;

    public ServicioCanciones(RepositorioCanciones repositorioCanciones){
        this.repositorioCanciones = repositorioCanciones;
    }

    public List<Cancion> obtenerTodas(){
        return this.repositorioCanciones.findAll();
    }

    public Cancion obtenerPorId(Long id){
        return this.repositorioCanciones.findById(id).orElse(null);
    }
    
    public Cancion agregarCancion(Cancion nuevaCancion){
        return this.repositorioCanciones.save(nuevaCancion);
    }

    public Cancion actualizarCancion(Cancion cancion){
        return this.repositorioCanciones.save(cancion);
    }

    public void eliminarCancion(Long idLibro){
        this.repositorioCanciones.deleteById(idLibro);
    }

}
