package org.kinscript.quimvana.dominio.service;

import org.kinscript.quimvana.dominio.dto.ModPeliculaDto;
import org.kinscript.quimvana.dominio.dto.PeliculaDto;
import org.kinscript.quimvana.repository.PeliculaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaService {

    private final PeliculaRepository peliculaRepository;

    public PeliculaService(PeliculaRepository peliculaRepository){
        this.peliculaRepository = peliculaRepository;
    }

    public List<PeliculaDto> obtenerTodo(){
        return this.peliculaRepository.obtenerTodo();
    }

    public PeliculaDto buscarPorCodigo (Long codigo) {
        return this.peliculaRepository.buscarPorCodigo(codigo);
    }

    public PeliculaDto guardarPelicula (PeliculaDto peliculaDto) {
        return this.peliculaRepository.guardarPelicula(peliculaDto);
    }

    public PeliculaDto modificarPelicula(Long codigo, ModPeliculaDto modPelicula) {
        return this.peliculaRepository.modificarPelicula(codigo, modPelicula);
    }

    public void eliminarPelicula (Long codigo) {
        this.peliculaRepository.eliminarPelicula(codigo);
    }

}
