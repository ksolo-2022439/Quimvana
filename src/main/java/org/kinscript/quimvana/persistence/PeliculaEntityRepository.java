package org.kinscript.quimvana.persistence;

import org.kinscript.quimvana.dominio.dto.ModPeliculaDto;
import org.kinscript.quimvana.dominio.dto.PeliculaDto;
import org.kinscript.quimvana.dominio.exception.PeliculaNoExisteException;
import org.kinscript.quimvana.dominio.exception.PeliculaYaExisteException;
import org.kinscript.quimvana.persistence.crud.CrudPeliculaEntity;
import org.kinscript.quimvana.persistence.entity.PeliculaEntity;
import org.kinscript.quimvana.persistence.mapper.PeliculaMapper;
import org.kinscript.quimvana.repository.PeliculaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class PeliculaEntityRepository implements PeliculaRepository {

    private final CrudPeliculaEntity crudPeliculaEntity;
    private final PeliculaMapper peliculaMapper;

    public PeliculaEntityRepository(CrudPeliculaEntity crudPeliculaEntity, PeliculaMapper peliculaMapper) {
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

    @Override
    public PeliculaDto guardarPelicula(PeliculaDto peliculaDto) {
        if (this.crudPeliculaEntity.findByTitulo(peliculaDto.getTitle()) != null) {
            throw new PeliculaYaExisteException(peliculaDto.getTitle());
        } else {
            PeliculaEntity peliculaEntity = this.peliculaMapper.toEntity(peliculaDto);
            peliculaEntity = this.crudPeliculaEntity.save(peliculaEntity);
            return this.peliculaMapper.toDto(peliculaEntity);
        }
    }

    @Override
    public PeliculaDto modificarPelicula(Long codigo, ModPeliculaDto modPelicula) {
        PeliculaEntity pelicula = this.crudPeliculaEntity.findById(codigo).orElse(null);
        if (pelicula != null) {
            this.peliculaMapper.modificarEntityFromDto(modPelicula, pelicula);
            return peliculaMapper.toDto(this.crudPeliculaEntity.save(pelicula));
        } else {
            throw new PeliculaNoExisteException(codigo);
        }
    }

    @Override
    public void eliminarPelicula(Long codigo) {
        PeliculaEntity pelicula = this.crudPeliculaEntity.findById(codigo).orElse(null);
        //Exceptions
        if (pelicula != null) {
            this.crudPeliculaEntity.delete(pelicula);
        } else {
            throw new PeliculaNoExisteException(codigo);
        }
    }
}
