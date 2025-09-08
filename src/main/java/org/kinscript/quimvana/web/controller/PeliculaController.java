package org.kinscript.quimvana.web.controller;

import org.kinscript.quimvana.dominio.dto.PeliculaDto;
import org.kinscript.quimvana.dominio.service.PeliculaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {
    private final PeliculaService peliculaService;

    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;

    }

    @GetMapping
    public List<PeliculaDto> obtenerPeliculas() {
        return this.peliculaService.obtenerTodo();
    }

    @GetMapping("/{codigo}")
    public PeliculaDto buscarPorCodigo(@PathVariable Long codigo) {
        return this.peliculaService.buscarPorCodigo(codigo);
    }

}