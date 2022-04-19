package es.drodriguez.com.DIP.SI;

public class ServicioSMS implements INotificacion {
    public void notification(String message){
        System.out.println("Escribiendo SMS ... " + message);
    }
}
