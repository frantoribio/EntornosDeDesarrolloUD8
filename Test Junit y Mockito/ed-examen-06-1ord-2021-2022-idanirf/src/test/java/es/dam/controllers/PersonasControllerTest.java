package es.dam.controllers;

import es.dam.errors.PersonaException;
import es.dam.models.Persona;
import es.dam.repositories.PersonasRepository;
import es.dam.repositories.PersonasRespositoryImpl;
import es.dam.services.PersonasStorage;
import es.dam.services.PersonasStorageImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Isolated;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@Isolated
class PersonasControllerTest {
    @Mock
    private PersonasRepository personasRepository;
    @Mock
    private PersonasStorage personasStorageTest;
    @InjectMocks
    PersonasController personasController;

    Persona personaTest = new Persona("Dani", 19, "54034501A");
    Persona storageTest1 = new Persona("Daniel", 20, "54034501A");
    Persona storageTest2 = new Persona("Danielito", 21, "54034501A");

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        personasController = new PersonasController(personasRepository, personasStorageTest);
    }

    // Crear todos los métodos necesarios de test para testar los casos correctos o incorrectos de
    // checkData()

    @Test
    void getPersonas() throws PersonaException {
       Mockito.when(personasRepository.getAll()).thenReturn(List.of(personaTest));
        personasController.savePersona(personaTest);
        var res = personasController.getPersonas();
        assertAll(
                () -> assertEquals( 1, res.size()),
                () -> assertEquals(res.get(0).getId(), personaTest.getId())
        );
        verify(personasRepository, times(1)).getAll();
    }

    @Test
    void getPersona() throws PersonaException {
        when(personasRepository.getById(personaTest.getId())).thenReturn(Optional.of(personaTest));
        personasRepository.save(personaTest);
        var res = personasController.getPersona(personaTest.getId());
        assertAll(
                ()-> assertEquals(res.getId(), personaTest.getId()),
                ()-> assertEquals(res.getNombre(), personaTest.getNombre())
        );
        verify(personasRepository, times(1)).getById(personaTest.getId());
    }

    @Test
    void getPersonaNoExiste() {
        when(personasRepository.getById(personaTest.getId())).thenReturn(Optional.empty());
        var resultado = assertThrows(PersonaException.class, () -> personasController.getPersona(personaTest.getId()));
        assertEquals("Persona no encontrada con id: " + personaTest.getId(), resultado.getMessage());
        verify(personasRepository, times(1)).getById(personaTest.getId());
    }

    @Test
    void savePersona() throws PersonaException {
        when(personasRepository.save(personaTest)).thenReturn(personaTest);
        var res = personasController.savePersona(personaTest);
        assertAll(
                ()-> assertEquals(res.getId(), personaTest.getId()),
                ()-> assertEquals(res.getNombre(), personaTest.getNombre())
        );
        verify(personasRepository, times(1)).save(personaTest);
    }

    @Test
    void updatePersona() throws PersonaException {
        when(personasRepository.update(any(Persona.class))).thenReturn(personaTest);
        var res = personasController.updatePersona(personaTest);
        assertAll(
                ()-> assertEquals(res.getId(), personaTest.getId()),
                ()-> assertEquals(res.getNombre(), personaTest.getNombre())
        );
        verify(personasRepository, times(1)).update(any(Persona.class));
    }



    @Test
    void deletePersonaNoExiste() throws PersonaException {
        doThrow(new PersonaException("Persona no encontrada con id: " + personaTest.getId())).when(personasRepository).delete(personaTest);
        var result1 = assertThrows(PersonaException.class,() -> personasController.deletePersonaPersona(personaTest));
        Assertions.assertAll(
                ()-> assertEquals(result1.getMessage(),"Persona no encontrada con id: " + personaTest .getId())
        );
        verify(personasRepository, times(1)).delete(personaTest);
    }

    @Test
    void deletePersonaUUID() throws PersonaException {
        when(personasRepository.delete(personaTest.getId())).thenReturn(Optional.of(personaTest));
        var resultado = personasController.deletePersonaById(personaTest.getId());
        assertAll(
                ()-> assertEquals(personaTest, resultado),
                ()->assertEquals(personaTest.getId(), resultado.getId())
        );
        verify(personasRepository, times(1)).delete(personaTest.getId());
    }

    @Test
    void deletePersonaUUIDNoExiste() {
        when(personasRepository.delete(personaTest.getId())).thenReturn(Optional.empty());
        var resultado = assertThrows(PersonaException.class, () -> personasController.deletePersonaById(personaTest.getId()));
        assertEquals("Persona no encontrada con id: " + personaTest.getId(), resultado.getMessage());
        verify(personasRepository, times(1)).delete(personaTest.getId());
    }

    @Test
    void updatePersonaNoExiste() throws PersonaException {
        doThrow(new PersonaException("Persona no encontrada con id: " + personaTest.getId())).when(personasRepository).update(personaTest);
        var result1 = assertThrows(PersonaException.class,() -> personasController.updatePersona(personaTest));
        Assertions.assertAll(
                ()-> assertEquals(result1.getMessage(),"Persona no encontrada con id: " + personaTest .getId())
        );
        verify(personasRepository, times(1)).delete(personaTest);
    }

    @Test
    void restoreData() {
        var lista = List.of(storageTest1, storageTest2);
        when(personasStorageTest.restore()).thenReturn(lista);
        var resultado = personasController.restoreData();
        assertAll(
                ()-> assertEquals(resultado.size(), 2),
                ()-> assertEquals(resultado.get(0).getId(), storageTest1.getId()),
                ()-> assertEquals(resultado.get(1).getId(), storageTest2.getId())
        );
        verify(personasStorageTest, times(1)).restore();
    }

    @Test
    void backupData() {
    }
}