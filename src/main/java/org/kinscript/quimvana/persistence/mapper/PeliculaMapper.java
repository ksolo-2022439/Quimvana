package org.kinscript.quimvana.persistence.mapper;

import org.kinscript.quimvana.dominio.dto.PeliculaDto;
import org.kinscript.quimvana.persistence.entity.PeliculaEntity;
import org.mapstruct.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Mapper(componentModel = "spring", uses = {GenderMapper.class})
public interface PeliculaMapper {

    @Mapping(source = "titulo", target = "title")
    @Mapping(source = "duracion", target = "duration")
    @Mapping(source = "genero", target = "gender", qualifiedByName = "generarGender")
    @Mapping(source = "fechaEstreno", target = "releaseDate")
    @Mapping(source = "calificacion", target = "rating")
    @Mapping(source = "estado", target = "disponible", qualifiedByName = "mapEstadoToDisponible")
    PeliculaDto toDto(PeliculaEntity entity);

    List<PeliculaDto> toDto(Iterable<PeliculaEntity> entities);

    @Named("mapEstadoToDisponible")
    default Boolean mapEstadoToDisponible(String estado) {
        return "D".equalsIgnoreCase(estado);
    }
}