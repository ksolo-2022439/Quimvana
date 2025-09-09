package org.kinscript.quimvana.dominio.dto;

import lombok.Data;
import org.kinscript.quimvana.dominio.Gender;

import java.time.LocalDate;
import java.util.List;

@Data
public class PeliculaDto {
    private Integer id;
    private String title;
    private Integer duration;
    private Gender gender;
    private LocalDate releaseDate;
    private Double rating;
    private Boolean status;

}