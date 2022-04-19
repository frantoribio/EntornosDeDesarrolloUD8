package es.drodriguez.com.ISP.SI;

public class Main {
    public static void main(String[] args) {
        CocheBueno bueno = new CocheBueno();
        bueno.acelarar();
        bueno.frenar();
        bueno.encenderMotor();
        bueno.pilotoAutomatico();
        bueno.noseque();
        CocheMedio medio = new CocheMedio();
        medio.acelarar();
        medio.frenar();
        medio.encenderMotor();
    }
}
