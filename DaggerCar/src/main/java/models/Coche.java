package models;

import java.util.UUID;

public class Coche {
    public String identificador = (UUID.randomUUID().toString());
    private String name;

    public Coche(String name) {
        this.name = name;
    }

    public String getIdentificador() {
        return identificador;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Coche: " + getIdentificador() + " " + name;
    }
}
