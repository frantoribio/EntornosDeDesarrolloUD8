package es.dam.repositories;

import es.dam.controllers.PersonasController;
import es.dam.errors.PersonaException;
import es.dam.models.Persona;
import es.dam.services.PersonasStorageImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonasRespositoryImplTest {
    PersonasRespositoryImpl personasRepository = new PersonasRespositoryImpl();
   private final Persona personaTest = new Persona("Dani", 19, "54034501A");

    @BeforeEach
    void setUp() {
        personasRepository.delete(personaTest.getId());
    }

    @Test
    void getAll() {
        personasRepository.save(personaTest);
        var resultado = personasRepository.getAll();
        assertAll(
                ()-> assertEquals(1, resultado.size()),
                ()-> assertEquals(personaTest.getId(), resultado.get(0).getId()),
                ()-> assertEquals(personaTest.getDni(), resultado.get(0).getDni())


        );
    }

    @Test
    void getById() {
        personasRepository.save(personaTest);
        var resultado = personasRepository.getById(personaTest.getId());
        var result = resultado.get();
        assertAll(
                ()-> assertEquals(result.getId(), personaTest.getId()),
                () -> assertEquals(result.getNombre(), personaTest.getNombre())
        );
    }

    @Test
    void getByIdNoExiste() {
        var res = personasRepository.getById(personaTest.getId());
        assertTrue(res.isEmpty());
    }

    @Test
    void save() {
        var res = personasRepository.save(personaTest);
        assertAll(
                ()->assertEquals(res.getId(), personaTest.getId()),
                ()->assertEquals(res.getNombre(), personaTest.getNombre())
        );
    }

    @Test
    void update() throws PersonaException {
        personasRepository.save(personaTest);
        personaTest.setEdad(21);
        var res = personasRepository.update(personaTest);
        assertAll(
                ()->assertEquals(res.getId(), personaTest.getId()),
                ()-> assertEquals(personaTest.getEdad(), res.getEdad())
        );
    }

    @Test
    void updateNoExiste() {
        var res = personasRepository.getById(personaTest.getId());
        assertTrue(res.isEmpty());
    }

    @Test
    void delete() throws PersonaException {
        personasRepository.save(personaTest);
        personasRepository.delete(personaTest);
        var res = personasRepository.getById(personaTest.getId());

        assertTrue(res.isEmpty());

    }

    @Test
    void deleteNoExiste() {
    }

    @Test
    void testDelete() {
        var res = personasRepository.delete(personaTest.getId());
        assertTrue(res.isEmpty());
    }
}