package es.joseluisgs.dam.controllers;

import es.joseluisgs.dam.errors.PersonaException;
import es.joseluisgs.dam.models.Persona;
import es.joseluisgs.dam.repositories.PersonasRepository;
import es.joseluisgs.dam.repositories.PersonasRespositoryImpl;
import es.joseluisgs.dam.services.PersonasStorage;
import es.joseluisgs.dam.services.PersonasStorageImpl;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

/**
 * Controlador de Personas.
 */
public class PersonasController {
PersonasRepository personasRepository;
public PersonasController(PersonasRepository personasRepository){
    this.personasRepository = personasRepository;
}
 private final PersonasStorage personasStorage = new PersonasStorageImpl();

    public List<Persona> getPersonas() {
        return personasRepository.getAll();
    }

    public Persona getPersona(UUID id) throws PersonaException {
        return personasRepository.getById(id)
                .orElseThrow(() -> new PersonaException("Persona no encontrada con id: " + id));
    }

    public Persona savePersona(Persona persona) {
        return personasRepository.save(persona);
    }

    public Persona updatePersona(Persona persona) {
        return personasRepository.update(persona);
    }


    public Persona deletePersona(UUID id) throws PersonaException {
        return personasRepository.delete(id)
                .orElseThrow(() -> new PersonaException("Persona no encontrada con id: " + id));
    }

    public List<Persona> restoreData() {
        return personasStorage.restore();
    }

    public void backupData(List<Persona> personas) {
        personasStorage.backup(personas);
    }

}
