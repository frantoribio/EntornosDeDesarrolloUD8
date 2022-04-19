package es.drodriguez.com.LSP.SI;

public class Niño extends Persona {
    Adultos responsable;

    //Constructor
    public Niño(String nombre, Adultos responsable) {
        super(nombre);
        this.responsable = responsable;
    }

    //Getter and Setter
    public Adultos getResponsable(){
        return responsable;
    }
    public void setResponsable(Adultos responsable){
        this.responsable = responsable;
    }
    //Métodos
    public void pagar(){
        responsable.pagar();
    }
}
