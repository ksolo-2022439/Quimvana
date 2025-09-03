package org.kinscript.quimvana.repository;

import org.kinscript.quimvana.dominio.dto.PeliculaDto;

import java.util.List;

public interface PeliculaRepository {
    //firmas de nuestros metodos a trabajar
    List<PeliculaDto> obtenerTodo();
}
