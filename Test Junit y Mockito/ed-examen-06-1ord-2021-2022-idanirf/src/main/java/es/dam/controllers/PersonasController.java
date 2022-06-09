package es.dam.controllers;

import es.dam.errors.PersonaException;
import es.dam.models.Persona;
import es.dam.repositories.PersonasRepository;
import es.dam.repositories.PersonasRespositoryImpl;
import es.dam.services.PersonasStorage;
import es.dam.services.PersonasStorageImpl;

import java.util.List;
import java.util.UUID;

/**
 * Controlador de Personas.
 */
public class PersonasController {
    PersonasRepository personasRepository;
    PersonasStorage personasStorage;

    public PersonasController(PersonasRepository personasRepository, PersonasStorage personasStorage) {
        this.personasRepository = personasRepository;
        this.personasStorage = personasStorage;
    }

    public List<Persona> getPersonas() {
        return personasRepository.getAll();
    }

    public Persona getPersona(UUID id) throws PersonaException {
        return personasRepository.getById(id)
                .orElseThrow(() -> new PersonaException("Persona no encontrada con id: " + id));
    }

    public Persona savePersona(Persona persona) throws PersonaException {
        checkData(persona);
        return personasRepository.save(persona);
    }

    public Persona updatePersona(Persona persona) throws PersonaException {
        checkData(persona);
        return personasRepository.update(persona);
    }

    public void deletePersonaPersona(Persona persona) throws PersonaException {
        if (persona != null) {
            personasRepository.delete(persona);
        }
    }

    public Persona deletePersonaById(UUID id) throws PersonaException {
        return personasRepository.delete(id)
                .orElseThrow(() -> new PersonaException("Persona no encontrada con id: " + id));
    }

    private void checkData(Persona persona) throws PersonaException {
        var regexDni = "^\\d{8}[A-Z]$";
        if (persona == null) {
            throw new PersonaException("Datos de personas no válidos");
        } else if (persona.getNombre() == null || persona.getNombre().isEmpty()) {
            throw new PersonaException("Nombre de persona no puede estar en blanco");
        } else if (persona.getEdad() < 10 || persona.getEdad() > 100) {
            throw new PersonaException("Edad de debe estar entre 10 y 100");
        } else if (persona.getDni() == null || persona.getDni().isEmpty()) {
            throw new PersonaException("DNI de persona no puede estar en blanco");
        } else if (!persona.getDni().matches(regexDni)) {
            throw new PersonaException("DNI con formato incorrecto");
        }
    }

    public List<Persona> restoreData() {
        return personasStorage.restore();
    }

    public void backupData(List<Persona> personas) {
        personasStorage.backup(personas);
    }

}
