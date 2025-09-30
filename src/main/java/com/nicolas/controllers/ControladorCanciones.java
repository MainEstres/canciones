package com.nicolas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.nicolas.models.Artista;
import com.nicolas.models.Cancion;
import com.nicolas.services.ServicioArtistas;
import com.nicolas.services.ServicioCanciones;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorCanciones {
    @Autowired
    private final ServicioCanciones servicioCanciones;

    @Autowired
    private final ServicioArtistas servicioArtistas;

    public ControladorCanciones(ServicioCanciones servicioCanciones, ServicioArtistas servicioArtistas) {
        this.servicioCanciones = servicioCanciones;
        this.servicioArtistas = servicioArtistas;
    }

    @GetMapping("/canciones")
    public String canciones(Model modelo) {
        List<Cancion> listaCanciones = this.servicioCanciones.obtenerTodas();
        modelo.addAttribute("listaCanciones", listaCanciones);
        return "canciones";
    }

    @GetMapping("/canciones/detalle/cancion/{idCancion}")
    public String detalleCancion(@PathVariable Long idCancion, Model modelo) {
        Cancion cancion = this.servicioCanciones.obtenerPorId(idCancion);
        if (cancion == null) {
            return "redirect:/canciones";
        }
        modelo.addAttribute("cancion", cancion);
        return "detalleCancion";
    }

    @GetMapping("/canciones/formulario/agregar")
    public String formularioCancion(@ModelAttribute("nuevaCancion") Cancion nuevaCancion, Model modelo) {
        List<Artista> artistas = this.servicioArtistas.obtenerArtistas();
        modelo.addAttribute("artistas", artistas);
        return "agregarCancion";
    }

    @PostMapping("/canciones/procesa/agregar")
    public String agregarCancion(@Valid @ModelAttribute("nuevaCancion") Cancion nuevaCancion,
            BindingResult validaciones, @RequestParam Long idArtista) {

        if (validaciones.hasErrors()) {
            return "agregarCancion";
        }

        Artista artista = this.servicioArtistas.obtenerArtistaId(idArtista);
        nuevaCancion.setArtista(artista);

        this.servicioCanciones.agregarCancion(nuevaCancion);
        return "redirect:/canciones";

    }

    @GetMapping("/canciones/formulario/editar/{idCancion}")
    public String formularioEditarCancion(@PathVariable Long idCancion, Model modelo) {
        Cancion cancion = this.servicioCanciones.obtenerPorId(idCancion);
        modelo.addAttribute("cancion", cancion);
        return "editarCancion";
    }

    @PutMapping("/canciones/procesa/editar/{idCancion}")
    public String actualizarCancion(@Valid @ModelAttribute("cancion") Cancion cancion,
            BindingResult validacioes,
            @PathVariable Long idCancion) {

        if (validacioes.hasErrors()) {
            return "editarCancion";
        }
        cancion.setId(idCancion);
        this.servicioCanciones.actualizarCancion(cancion);

        return "redirect:/canciones/detalle/cancion/" + idCancion;
    }

    @DeleteMapping("/canciones/eliminar/{idCancion}")
    public String eliminarCancion(@PathVariable Long idCancion){
        this.servicioCanciones.eliminarCancion(idCancion);
        return "redirect:/canciones";
    }

    

}
