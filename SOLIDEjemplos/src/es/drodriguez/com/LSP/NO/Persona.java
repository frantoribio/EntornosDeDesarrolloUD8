package es.drodriguez.com.LSP.NO;

public class Persona {
    private String dni;
    private String nombre;
    private String tarjeta;

    //Getter and setter
    public String getDni(){
        return dni;
    }
    public void setDni(String dni){
        this.dni = dni;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    } public String getTarjeta() {
        return tarjeta;
    }
    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }
    public Persona(String dni, String nombre, String tarjeta) {
        super();
        this.dni = dni;
        this.nombre = nombre;
        this.tarjeta = tarjeta;
    }

    public void pagar(){
        System.out.println("Nombre: " + nombre + "con tarjeta Nº: " + tarjeta);
    }
}
