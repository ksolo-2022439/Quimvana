package org.kinscript.quimvana.web.exception;

import org.kinscript.quimvana.dominio.exception.Error;
import org.kinscript.quimvana.dominio.exception.PeliculaNoExisteException;
import org.kinscript.quimvana.dominio.exception.PeliculaYaExisteException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(PeliculaYaExisteException.class)
    public ResponseEntity<Error> handleException(PeliculaYaExisteException ex) {
        Error error = new Error("pelicula-ya-existe", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(PeliculaNoExisteException.class)
    public ResponseEntity<Error> handleException(PeliculaNoExisteException ex) {
        Error error = new Error("pelicula-no-existe", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    //validacion de datos

}
