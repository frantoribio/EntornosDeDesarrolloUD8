package es.drodriguez.com.LSP.NO;

public class Main {
    public static void main(String[] args){
        Persona pers = new Persona("1235678A", "Daniel", "12356");
        pers.pagar();
        pers = new Niño("Nene");
        pers.pagar();

    }
}
