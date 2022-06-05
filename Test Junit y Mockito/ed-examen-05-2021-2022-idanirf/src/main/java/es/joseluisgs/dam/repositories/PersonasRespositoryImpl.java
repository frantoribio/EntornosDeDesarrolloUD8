package es.joseluisgs.dam.repositories;

import es.joseluisgs.dam.models.Persona;

import javax.inject.Inject;
import java.util.*;

/**
 * Implementación del Repositorio for {@link Persona}s.
 */

public class PersonasRespositoryImpl implements PersonasRepository {

    HashMap<UUID, Persona> personas = new HashMap<>();

    @Override
    public List<Persona> getAll() {
        return new ArrayList<>(personas.values());
    }

    @Override
    public Optional<Persona> getById(UUID uuid) {
        return Optional.ofNullable(personas.get(uuid));
    }

    @Override
    public Persona save(Persona entity) {
        personas.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public Persona update(Persona entity) {
        personas.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public Optional<Persona> delete(UUID id) {
        return Optional.ofNullable(personas.remove(id));
    }

    public void deleteAll() {
        System.out.println("PersonaRepository.deleteAll");
        personas.clear();
    }
}

