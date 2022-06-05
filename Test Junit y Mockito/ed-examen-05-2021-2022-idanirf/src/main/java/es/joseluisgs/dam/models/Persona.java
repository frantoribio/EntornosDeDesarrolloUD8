package es.joseluisgs.dam.models;

import java.util.UUID;

public class Persona {
    private UUID id;
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.id = UUID.randomUUID();
        this.nombre = nombre;
        this.edad = edad;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}
