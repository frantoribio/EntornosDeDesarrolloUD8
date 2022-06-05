package es.joseluisgs.dam;

import es.joseluisgs.dam.controllers.PersonasController;
import es.joseluisgs.dam.errors.PersonaException;
import es.joseluisgs.dam.models.Persona;
import es.joseluisgs.dam.repositories.PersonasRepository;
import es.joseluisgs.dam.repositories.PersonasRespositoryImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        System.out.println("Entornos de Desarrollo");
        manual();

    }


    private static void manual() {
        // Creamos el controlador, debes modificarlo para trabajar correctamente con las dependencias
        PersonasController personasController = new PersonasController(new PersonasRespositoryImpl());

        // Recuperamos los datos
        System.out.println("Recuperando datos");
        var list = personasController.restoreData();

        // insertamos los datos
        System.out.println("Insertando datos");
        list.forEach(personasController::savePersona);
        // obtenemos todas las personas
        System.out.println("Obteniendo todas las personas");
        var personas = personasController.getPersonas();
        personas.forEach(System.out::println);
        // añadimos una persona
        System.out.println("Añadiendo una persona");
        var persona = personasController.savePersona(new Persona("Examen", 25));
        System.out.println(persona);
        // obtenemos una persona
        System.out.println("Obteniendo una persona");
        try {
            persona = personasController.getPersona(personas.get(0).getId());
        } catch (PersonaException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(persona);
        // modificamos una persona
        System.out.println("Modificando una persona");
        persona.setEdad(30);
        persona= personasController.updatePersona(persona);
        System.out.println(persona);
        // borramos una persona
        System.out.println("Borrando una persona");
        try {
            persona= personasController.deletePersona(persona.getId());
        } catch (PersonaException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(persona);

        // Hacemos un backup
        System.out.println("Haciendo un backup");
        personasController.backupData(personasController.getPersonas());
    }
}