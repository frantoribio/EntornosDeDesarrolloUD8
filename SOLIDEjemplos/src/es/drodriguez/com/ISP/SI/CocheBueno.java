package es.drodriguez.com.ISP.SI;

public class CocheBueno implements Coche, IBueno {
    @Override
    public void acelarar() {
        System.out.println("Coche bueno acelerando");
    }

    @Override
    public void frenar() {
        System.out.println("Coche Bueno frenando");
    }

    @Override
    public void encenderMotor() {
        System.out.println("Coche bueno encendiendo motor");
    }

    @Override
    public void pilotoAutomatico() {
        System.out.println("Coche bueno con el piloto automático");
    }

    @Override
    public void noseque() {
        System.out.println("Coche bueno en el modo yo que se cual");
    }
}
