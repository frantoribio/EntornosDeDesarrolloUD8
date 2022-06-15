package es.dam.services;

import es.dam.models.Persona;

import java.util.List;

public interface PersonasStorage extends Storage<Persona> {
    List<Persona> restore();
    boolean backup(List<Persona> list);
}

