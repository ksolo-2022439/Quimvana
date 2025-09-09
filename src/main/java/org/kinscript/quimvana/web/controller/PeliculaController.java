package org.kinscript.quimvana.web.controller;

import org.hibernate.result.Output;
import org.kinscript.quimvana.dominio.dto.ModPeliculaDto;
import org.kinscript.quimvana.dominio.dto.PeliculaDto;
import org.kinscript.quimvana.dominio.service.PeliculaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {
    private final PeliculaService peliculaService;

    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;

    }

    @GetMapping
    public ResponseEntity<List<PeliculaDto>> obtenerPeliculas() {
        return ResponseEntity.ok(peliculaService.obtenerTodo());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<PeliculaDto> buscarPorCodigo(@PathVariable Long codigo) {
        return ResponseEntity.ok(peliculaService.buscarPorCodigo(codigo));
    }

    @PostMapping
    public ResponseEntity<PeliculaDto> guadarPelicula(@RequestBody PeliculaDto peliculaDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.peliculaService.guardarPelicula(peliculaDto));
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<PeliculaDto> modificarPelicula(@PathVariable Long codigo, @RequestBody ModPeliculaDto modPelicula) {
        return ResponseEntity.ok(this.peliculaService.modificarPelicula(codigo, modPelicula));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> eliminarPelicula(@PathVariable Long codigo) {
        this.peliculaService.eliminarPelicula(codigo);
        return ResponseEntity.ok().build();
    }
}