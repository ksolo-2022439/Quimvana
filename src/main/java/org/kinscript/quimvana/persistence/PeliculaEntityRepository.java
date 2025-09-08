package org.kinscript.quimvana.persistence;

import org.kinscript.quimvana.dominio.dto.PeliculaDto;
import org.kinscript.quimvana.persistence.crud.CrudPeliculaEntity;
import org.kinscript.quimvana.persistence.mapper.PeliculaMapper;
import org.kinscript.quimvana.repository.PeliculaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PeliculaEntityRepository implements PeliculaRepository {

    private final CrudPeliculaEntity crudPeliculaEntity;
    private final PeliculaMapper peliculaMapper;

    public PeliculaEntityRepository(CrudPeliculaEntity crudPeliculaEntity, PeliculaMapper peliculaMapper){
        this.crudPeliculaEntity = crudPeliculaEntity;
        this.peliculaMapper = peliculaMapper;
    }

    @Override
    public List<PeliculaDto> obtenerTodo() {
        return this.peliculaMapper.toDto(this.crudPeliculaEntity.findAll());
    }

    @Override
    public PeliculaDto buscarPorCodigo(Long codigo) {
        return this.peliculaMapper.toDto(this.crudPeliculaEntity.findById(codigo).orElse(null));
    }
}
