package org.kinscript.quimvana.repository;

import org.kinscript.quimvana.dominio.dto.PeliculaDto;
import org.kinscript.quimvana.web.controller.PeliculaController;

import java.util.List;

public interface PeliculaRepository {
    //firmas de nuestros metodos a trabajar
    List<PeliculaDto> obtenerTodo();
    public PeliculaDto buscarPorCodigo(Long codigo);
}
