package es.joseluisgs.dam.repository;

import es.joseluisgs.dam.controllers.PersonasController;
import es.joseluisgs.dam.models.Persona;
import es.joseluisgs.dam.repositories.PersonasRepository;
import es.joseluisgs.dam.repositories.PersonasRespositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class PersonasRepositoryImplTest {
    private final PersonasRespositoryImpl personasRepository = new PersonasRespositoryImpl();

    Persona personaTest = new Persona("Dani", 19);

    @BeforeEach
    void setAll(){
        personasRepository.deleteAll();
    }
    @Test
    void getPersonas() {
        personasRepository.save(personaTest);
        var result = personasRepository.getAll();
        assertAll(
                ()-> assertEquals(1, result.size()),
                ()-> assertEquals(personaTest, result.get(0))
        );
    }

    @Test
    void deletePersonas() {
        personasRepository.save(personaTest);
        var result = personasRepository.delete(personaTest.getId());
        var resultado = result.get();
        assertAll(
                ()->assertTrue(result.isPresent()),
                ()->assertEquals(personaTest, resultado),
                ()->assertEquals(personaTest.getNombre(), resultado.getNombre())
        );
    }

    @Test
    void save() {
        var result = personasRepository.save(personaTest);
        assertAll(
                ()->assertEquals(personaTest.getNombre(), result.getNombre()),
                ()->assertEquals(personaTest.getEdad(), result.getEdad())
        );
    }

    @Test
    void searchByIdNoExiste(){
        var result =personasRepository.getById(personaTest.getId());
        assertTrue(result.isEmpty());
    }

    @Test
    void deteleByIdNoExiste(){
        var result = personasRepository.delete(personaTest.getId());
        assertFalse(result.isPresent());
    }

    @Test
    void updatePersona(){
        personasRepository.save(personaTest);
        personaTest.setEdad(21);
        var resultado = personasRepository.update(personaTest);
        System.out.println(personaTest);
        assertAll(
                ()-> assertEquals(personaTest.getEdad(), resultado.getEdad()),
                ()-> assertEquals(personaTest.getNombre(), resultado.getNombre())
        );
    }
}
