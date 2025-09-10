package org.kinscript.quimvana.dominio.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;
import org.kinscript.quimvana.dominio.Gender;

import java.time.LocalDate;
import java.util.List;

@Data
public class PeliculaDto {
    private Integer id;
    @NotBlank(message = "El titulo es obligatorio")
    private String title;
    @Min(value = 0, message = "La duracion no puede ser menor que 0")
    private Integer duration;
    @NotBlank(message = "El genero es obligatorio")
    private Gender gender;
    @PastOrPresent(message = "La fecha de lanzamiento debe ser entre el pasado y el presente")
    private LocalDate releaseDate;
    @Min(value = 0, message= "La calificacion no puede ser menor que 0")
    @Max(value = 10, message= "La calificacion no puede ser mayor a 10")
    private Double rating;
    @NotBlank(message= "El estado debe ser D o N")
    private Boolean status;

}