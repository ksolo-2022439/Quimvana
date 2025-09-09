package org.kinscript.quimvana.persistence.mapper;

import org.kinscript.quimvana.dominio.dto.PeliculaDto;
import org.kinscript.quimvana.persistence.entity.PeliculaEntity;
import org.mapstruct.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Mapper(componentModel = "spring", uses = {GenderMapper.class})
public interface PeliculaMapper {

    @Named("mapEstadoToDisponible")
    default Boolean mapEstadoToDisponible(String estado) {
        return "D".equalsIgnoreCase(estado);
    }

    @Named("mapDisponibleToEstado")
    default String mapDisponibleToEstado(Boolean disponible) {
        if (disponible == null) {
            return null;
        }
        return disponible ? "D" : "N";
    }

    @Named("mapRatingToCalificacion")
    default BigDecimal mapRatingToCalificacion(Double rating) {
        if (rating == null) {
            return BigDecimal.ZERO;
        }
        return BigDecimal.valueOf(rating);
    }

    @Mapping(source = "titulo", target = "title")
    @Mapping(source = "duracion", target = "duration")
    @Mapping(source = "genero", target = "gender", qualifiedByName = "generarGender")
    @Mapping(source = "fechaEstreno", target = "releaseDate")
    @Mapping(source = "calificacion", target = "rating")
    @Mapping(source = "estado", target = "status", qualifiedByName = "mapEstadoToDisponible")
    PeliculaDto toDto(PeliculaEntity entity);

    List<PeliculaDto> toDto(Iterable<PeliculaEntity> entities);

    @InheritInverseConfiguration
    @Mapping(source = "gender", target = "genero", qualifiedByName = "generarGenero")
    @Mapping(source = "status", target = "estado", qualifiedByName = "mapDisponibleToEstado")
    @Mapping(source = "rating", target = "calificacion", qualifiedByName = "mapRatingToCalificacion")
    PeliculaEntity toEntity(PeliculaDto dto);
}