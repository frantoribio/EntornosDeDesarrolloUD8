package es.joseluisgs.dam.controllers;


import es.joseluisgs.dam.errors.PersonaException;
import es.joseluisgs.dam.models.Persona;
import es.joseluisgs.dam.repositories.PersonasRespositoryImpl;
import es.joseluisgs.dam.services.PersonasStorageImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Isolated;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.matchers.Any;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Test de PersonasController.
 * Debes configurar todo lo que estimes, ya sea anotaciones,
 * como extensiones
 * Como elementos que se necesiten.
 */
@ExtendWith(MockitoExtension.class)
@Isolated
class PersonasControllerTest {
    @Mock
    PersonasRespositoryImpl personasRespository = new PersonasRespositoryImpl();
    PersonasStorageImpl personasStorageTest = new PersonasStorageImpl();

    @InjectMocks
    PersonasController personasController = new PersonasController(new PersonasRespositoryImpl(), new PersonasStorageImpl());

    Persona personaTest = new Persona("Dani", 19);
    Persona storageTest1 = new Persona("Daniel", 20);
    Persona storageTest2 = new Persona("Danielito", 21);

    @Test
    void getPersonas() {
        when(personasRespository.getAll()).thenReturn(List.of(personaTest));
        var resultado = personasController.getPersonas();
        assertAll(
                ()-> assertEquals(1,resultado.size()),
                ()-> assertEquals(personaTest, resultado.get(0))
        );
        verify(personasRespository, times(1)).getAll();
    }

    @Test
    void getPersonaById() throws PersonaException {
        when(personasRespository.getById(personaTest.getId())).thenReturn(Optional.ofNullable(personaTest));
        var resultado = personasController.getPersona(personaTest.getId());
        assertAll(
                ()->  assertEquals(resultado.getId(), personaTest.getId()),
                ()-> assertEquals(resultado.getNombre(), personaTest.getNombre())
        );
        verify(personasRespository, times(1)).getById(personaTest.getId());
    }

    @Test
    void getPersonaByIdNoExiste() {
        when(personasRespository.getById(personaTest.getId())).thenReturn(Optional.empty());
        var resultado = assertThrows(PersonaException.class, () -> personasController.getPersona(personaTest.getId()));
        assertEquals("Persona no encontrada con id: " + personaTest.getId(),resultado.getMessage());
        verify(personasRespository, times(1)).getById(personaTest.getId());

    }

    @Test
    void savePersona() {
        when(personasRespository.save(personaTest)).thenReturn(personaTest);
        var resultado = personasController.savePersona(personaTest);
        assertAll(
                ()-> assertEquals(resultado.getNombre(), personaTest.getNombre()),
                ()-> assertEquals(resultado.getEdad(),personaTest.getEdad())
        );
        verify(personasRespository, times(1)).save(personaTest);
    }

    @Test
    void deletePersonaById() throws PersonaException {
            when(personasRespository.delete(personaTest.getId())).thenReturn(Optional.of(personaTest));
            var resultado = personasController.deletePersona(personaTest.getId());
            assertAll(
                    ()-> assertEquals(personaTest, resultado),
                    ()-> assertEquals(personaTest.getEdad(),resultado.getEdad())
            );
            verify(personasRespository, times(1)).delete(personaTest.getId());
        }


    @Test
    void deletePersonaByIdNoExiste() {
        when(personasRespository.delete(personaTest.getId())).thenReturn(Optional.empty());
        var resultado = assertThrows(PersonaException.class, ()-> personasController.deletePersona(personaTest.getId()));
        assertEquals("Persona no encontrada con id: " + personaTest.getId(), resultado.getMessage());
        verify(personasRespository, times(1)).delete(personaTest.getId());
    }

    @Test
    void restoreData() {
        when(personasStorageTest.restore()).thenReturn(List.of(storageTest1, storageTest2));
        var resultado = personasController.restoreData();
        assertAll(
                ()-> assertEquals(resultado.size(), 2),
                ()-> assertEquals(resultado.get(0).getId(), storageTest1.getId()),
                ()-> assertEquals(resultado.get(1).getId(), storageTest2.getId())
        );
        verify(personasStorageTest, times(1)).restore();
    }

    @Test
    void updatePersona() {
        when(personasRespository.update(any(Persona.class))).thenReturn(personaTest);
        var resultado = personasController.updatePersona(personaTest);
        assertAll(
                ()-> assertEquals(personaTest, resultado),
                ()-> assertEquals(personaTest.getId(), resultado.getId()),
                ()-> assertEquals(personaTest.getEdad(), resultado.getEdad())
        );

        verify(personasRespository, times(1)).update(any(Persona.class));
    }
}