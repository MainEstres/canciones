package com.nicolas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.nicolas.models.Artista;
import com.nicolas.services.ServicioArtistas;
import org.springframework.web.bind.annotation.PostMapping;







@Controller
public class ControladorArtistas {

    @Autowired
    private final ServicioArtistas servicioArtistas;

    public ControladorArtistas (ServicioArtistas servicioArtistas){
        this.servicioArtistas = servicioArtistas;
    }   

    @GetMapping("/artistas")
    public String desplegarArtistas(Model modelo){
        List<Artista> listaArtistas = this.servicioArtistas.obtenerArtistas();
        modelo.addAttribute("listaArtistas", listaArtistas);
        return "artistas";
    }

    @GetMapping("/artistas/detalle/{idArtista}")
    public String detalleArtista(@PathVariable Long idArtista, Model modelo) {
        Artista artista = this.servicioArtistas.obtenerArtistaId(idArtista);

        if(artista == null){
            return "redirect:/artistas";
        }

        modelo.addAttribute("artista", artista);
        return "detalleArtista";
    }

    @GetMapping("/artistas/formulario/agregar")
    public String formularioArtista(@ModelAttribute("nuevoArtista") Artista artista) {
        return "agregarArtista";
    }

    @PostMapping("/artistas/procesa/agregar")
    public String agregarArtista(@ModelAttribute("nuevoArtista") Artista artista, BindingResult validaciones) {
        
        if(validaciones.hasErrors()){
            return "agregarArtista";
        }

        this.servicioArtistas.agregarArtista(artista);
        return "redirect:/artistas";
    }
    
    
    

  
}
