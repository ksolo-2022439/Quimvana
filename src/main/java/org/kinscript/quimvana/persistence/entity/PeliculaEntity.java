package org.kinscript.quimvana.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Peliculas")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class PeliculaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPelicula;
    @Column(name = "titulo", length = 150, unique = true, nullable = false)
    private String titulo;
    @Column(name = "duracion", precision = 3, scale = 2, nullable = false)
    private Integer duracion;
    @Column(name = "genero", length = 40, nullable = false)
    private String genero;
    @Column(name = "fecha_estreno")
    private LocalDate fechaEstreno;
    @Column(name = "calificacion", precision = 3, scale = 2, nullable = false)
    private BigDecimal calificacion;
    @Column(name = "estado", length = 1, nullable = false)
    private String estado;
}
