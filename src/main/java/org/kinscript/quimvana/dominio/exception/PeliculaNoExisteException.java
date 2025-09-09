package org.kinscript.quimvana.dominio.exception;

public class PeliculaNoExisteException extends RuntimeException {
    public PeliculaNoExisteException(Long codigo) {
        super("Pelicula no encontrada: " + codigo);
    }
}