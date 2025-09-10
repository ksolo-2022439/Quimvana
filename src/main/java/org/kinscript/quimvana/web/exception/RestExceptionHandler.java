package org.kinscript.quimvana.web.exception;

import org.kinscript.quimvana.dominio.exception.Error;
import org.kinscript.quimvana.dominio.exception.PeliculaNoExisteException;
import org.kinscript.quimvana.dominio.exception.PeliculaYaExisteException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

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
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<Error>> handleException(MethodArgumentNotValidException ex) {
        List<Error> errores = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(fieldError -> {
            errores.add(new Error(fieldError.getField(), fieldError.getDefaultMessage()));
        });
    return ResponseEntity.badRequest().body(errores);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleException(Exception ex) {
        Error error = new Error ("Error desconocido", ex.getMessage());
        return ResponseEntity.internalServerError().body(error);
    }
}
