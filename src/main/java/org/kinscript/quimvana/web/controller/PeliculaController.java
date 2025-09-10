package org.kinscript.quimvana.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.hibernate.result.Output;
import org.kinscript.quimvana.dominio.dto.ModPeliculaDto;
import org.kinscript.quimvana.dominio.dto.PeliculaDto;
import org.kinscript.quimvana.dominio.dto.SolicitudDto;
import org.kinscript.quimvana.dominio.service.AiServiceQuimvana;
import org.kinscript.quimvana.dominio.service.PeliculaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/peliculas")
@Tag(name = "Peliculas",
        description= "Operaciones crud sobre peliculas dentro de quimvana")
public class PeliculaController {
    private final PeliculaService peliculaService;
    private final AiServiceQuimvana aiServiceQuimvana;

    public PeliculaController(PeliculaService peliculaService, AiServiceQuimvana aiServiceQuimvana) {
        this.peliculaService = peliculaService;
        this.aiServiceQuimvana = aiServiceQuimvana;
    }

    @GetMapping
    public ResponseEntity<List<PeliculaDto>> obtenerPeliculas() {
        return ResponseEntity.ok(peliculaService.obtenerTodo());
    }


    @PostMapping("/sugerir")
    public ResponseEntity<String> generarSugerenciaPelicula(@RequestBody SolicitudDto solicitudDto) {
        return ResponseEntity.ok(this.aiServiceQuimvana.generarSugerenciaPelicula(solicitudDto.preferencias()));
    }

    @PostMapping
    public ResponseEntity<PeliculaDto> guadarPelicula(@RequestBody @Valid PeliculaDto peliculaDto) {
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

    @GetMapping("{codigo}")
    @Operation(summary = "Obtener una pelicula por su identificador",
            description = "Retorna la pelicula que coincida con el identificador enviado",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Pelicula encontrada"),
                    @ApiResponse(responseCode = "404", description = "Pelicula no encontrada", content = @Content)
            })

    public ResponseEntity<PeliculaDto> buscarPorCodigo
            (@Parameter(description = "Identificador de la pelicula a recuperar", example = "7")
             @PathVariable Long codigo){
        return ResponseEntity.ok(this.peliculaService.buscarPorCodigo(codigo));
    }
}