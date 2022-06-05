package es.joseluisgs.dam.repositories;

import es.joseluisgs.dam.models.Persona;

import java.util.Optional;
import java.util.UUID;

/**
 * Repositorio for {@link Persona}s.
 */
public interface PersonasRepository extends CrudRepository<Persona, UUID> {
    Optional<Persona> delete(UUID id);
}


