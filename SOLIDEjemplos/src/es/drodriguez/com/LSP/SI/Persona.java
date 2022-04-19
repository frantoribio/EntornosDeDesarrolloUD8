package es.drodriguez.com.LSP.SI;

public abstract class Persona {
    private String nombre;

    //Construtor
    public Persona( String nombre) {
        super();
        this.nombre = nombre;
    }

    //Getter and Setter
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //De forma abstracta implementamos el método pagar
    abstract public void pagar();
}
