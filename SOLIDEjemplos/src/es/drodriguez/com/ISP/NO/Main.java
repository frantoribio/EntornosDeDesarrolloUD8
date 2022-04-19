package es.drodriguez.com.ISP.NO;

public class Main {
    public static void main(String[] args) {
        Coche coche = new CocheMedio();
        coche.acelarar();
        coche.frenar();
        coche.encenderMotor();
        coche.pilotoAutomatico();
        coche.noseque();
        coche = new CocheBueno();
        coche.acelarar();
        coche.frenar();
        coche.encenderMotor();
        coche.pilotoAutomatico();
        coche.noseque();
    }
}
