package org.kinscript.quimvana.web.controller;

import org.kinscript.quimvana.dominio.dto.PeliculaDto;
import org.kinscript.quimvana.dominio.service.PeliculaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class PeliculaController {
    private final PeliculaService peliculaService;

    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;

    }

    @GetMapping("/peliculas")
    public List<PeliculaDto> obtenerPeliculas() {
        return this.peliculaService.obtenerTodo();
    }
}