package es.drodriguez.com.ISP.SI;

public class CocheMedio implements Coche {
    @Override
    public void acelarar() {
        System.out.println("Coche medio acelerando");
    }

    @Override
    public void frenar() {
        System.out.println("Coche Medio Frenanado");
    }

    @Override
    public void encenderMotor() {
        System.out.println("Coche Medio encenderMotor");
    }
}
