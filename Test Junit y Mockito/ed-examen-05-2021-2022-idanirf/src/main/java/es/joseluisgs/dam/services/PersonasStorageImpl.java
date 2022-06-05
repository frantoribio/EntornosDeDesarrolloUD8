package es.joseluisgs.dam.services;

import es.joseluisgs.dam.models.Persona;

import java.util.List;

/**
 * Implementación del Servicio de almacenamiento de {@link Persona}s.
 */
public class PersonasStorageImpl implements PersonasStorage {

    @Override
    public List<Persona> restore() {
        return List.of(
                new Persona("Ana", 20),
                new Persona("Juan", 22)
        );
    }

    @Override
    public boolean backup(List<Persona> list) {
        list.forEach(System.out::println);
        return true;
    }

}

