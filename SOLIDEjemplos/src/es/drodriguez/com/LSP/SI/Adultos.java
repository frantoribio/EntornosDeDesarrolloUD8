package es.drodriguez.com.LSP.SI;

public class Adultos extends Persona {
    String dni;
    String tarjeta;

    //Constructor
    public Adultos(String nombre, String dni, String tarjeta) {
        super(nombre);
        this.dni = dni;
        this.tarjeta = tarjeta;
    }

    //Getter and Setter de la Clase POJO
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    //Método pagar
    public void pagar() {
        System.out.println("Nombre: " +getNombre() + "con tarjeta Nº: " + tarjeta);
    }
}
