package es.drodriguez.com.DIP.SI;

public class ServicioCorreo implements INotificacion {
    public void notification(String message){
        System.out.println("Escribiendo mensaje ... " + message);
    }
}
