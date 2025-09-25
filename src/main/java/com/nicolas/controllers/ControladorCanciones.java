package com.nicolas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.nicolas.models.Cancion;
import com.nicolas.services.ServicioCanciones;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class ControladorCanciones {
    @Autowired
    private final ServicioCanciones servicioCanciones;

    public ControladorCanciones(ServicioCanciones servicioCanciones) {
        this.servicioCanciones = servicioCanciones;
    }

    @GetMapping("/canciones")
    public String canciones(Model modelo) {
        List<Cancion> listaCanciones = this.servicioCanciones.obtenerTodas();
        modelo.addAttribute("listaCanciones", listaCanciones);
        return "canciones";
    }

    @GetMapping("/detalle/cancion/{idCancion}")
    public String detalleCancion(@PathVariable Long idCancion, Model modelo) {
        Cancion cancion = this.servicioCanciones.obtenerPorId(idCancion);
        if (cancion == null) {
            return "redirect:/canciones";
        }
        modelo.addAttribute("cancion", cancion);
        return "detalleCancion";
    }

    @GetMapping("/formulario/agregar")
    public String formularioCancion(@ModelAttribute("nuevaCancion") Cancion nuevaCancion) {
        return "agregarCancion";
    }

    @PostMapping("/procesa/agregar")
    public String agregarCancion(@Valid @ModelAttribute("nuevaCancion") Cancion nuevaCancion,
            BindingResult validaciones) {

        if (validaciones.hasErrors()) {
            return "agregarCancion";
        }
        this.servicioCanciones.agregarCancion(nuevaCancion);
        return "redirect:/canciones";

    }

    @GetMapping("/formulario/editar/{idCancion}")
    public String formularioEditarCancion(@PathVariable Long idCancion, Model modelo) {
        Cancion cancion = this.servicioCanciones.obtenerPorId(idCancion);
        modelo.addAttribute("cancion", cancion);
        return "editarCancion";
    }

    @PutMapping("/procesa/editar/{idCancion}")
    public String putMethodName(@Valid @ModelAttribute("cancion") Cancion cancion,
            BindingResult validacioes,
            @PathVariable Long idCancion) {

        if (validacioes.hasErrors()) {
            return "editarCancion";
        }
        cancion.setId(idCancion);
        this.servicioCanciones.actualizarCancion(cancion);

        return "redirect:/detalle/cancion/" + idCancion;
    }

    @DeleteMapping("/eliminar/{idCancion}")
    public String eliminarCancion(@PathVariable Long idCancion){
        this.servicioCanciones.eliminarCancion(idCancion);
        return "redirect:/canciones";
    }

    

}
