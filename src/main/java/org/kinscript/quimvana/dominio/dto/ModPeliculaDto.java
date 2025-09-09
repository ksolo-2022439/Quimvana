package org.kinscript.quimvana.dominio.dto;

import java.time.LocalDate;

public record ModPeliculaDto(
        String title,
        LocalDate releaseDate,
        Double rating
) {
}
