package es.drodriguez.com.LSP.NO;

public class Niño extends Persona {

    public Niño(String nombre) {
        super(null, nombre, null);
    }

    @Override
    public void pagar(){
        //AHORA QUE!! Lanzo una excepción porque el nene no puede pagar, lanzar una excepción no es la mejor solución
        throw new RuntimeException("Ahora lanzo una excepción porque los niños no pueden pagar");
    }
}
