package org.kinscript.quimvana.dominio.exception;

public class PeliculaYaExisteException extends RuntimeException {
    public PeliculaYaExisteException(String tituloPelicula) {
        super("Esta pelicula ya existe, el titulo es: " + tituloPelicula);
    }
}