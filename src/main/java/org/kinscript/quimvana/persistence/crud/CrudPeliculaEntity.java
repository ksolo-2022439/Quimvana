package org.kinscript.quimvana.persistence.crud;

import org.kinscript.quimvana.persistence.entity.PeliculaEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudPeliculaEntity extends CrudRepository<PeliculaEntity, Long> {
    // Creamos el "DAO" o acceso a el CRUD de mi clase de entidad

    PeliculaEntity findByTitulo(String tituloPelicula);

}
