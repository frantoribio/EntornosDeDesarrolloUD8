package es.drodriguez.com.LSP.SI;

public class Main {
    public static void main(String[] args) {
        Persona pers = new Adultos("Daniel", "12344567A", "123");
        pers.pagar();

        Persona pers1 = new Niño("José Luis", (Adultos)pers);
        pers.pagar();
    }
}
