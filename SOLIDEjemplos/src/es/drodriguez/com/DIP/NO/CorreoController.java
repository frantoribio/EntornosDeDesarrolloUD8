package es.drodriguez.com.DIP.NO;

public class CorreoController {
    /*
    Vale y sí ahora quiero tener otro servicio que sea de SMS o WhatsApp ¿¿¿qué hago???, pues este ejemplo no nos sirve
     */

    private ServicioCorreo notificacion = new ServicioCorreo();

    public void recibirNotificacion(){
        notificacion.notification("Hola Nene!");
    }

    public static void main(String[] args) {
        CorreoController correoController = new CorreoController();
        correoController.recibirNotificacion();
    }
}
