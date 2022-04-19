package es.drodriguez.com.DIP.SI;

public class ControllerService {
    //EA ahora sí que podemos tener varios servicios, de esta forma no acoplamos código "Alta Cohesión Bajo Acoplamiento"
    private INotificacion notificacion;

    //Constructor con inyección de dependencias
    public ControllerService(INotificacion notificacion){this.notificacion = notificacion;}

    public void recibirNotificacion(){
        notificacion.notification("HOLA NENE!!");
    }

    public static void main(String[] args) {
        ControllerService controllerService = new ControllerService(new ServicioCorreo());
        controllerService.recibirNotificacion();
        controllerService = new ControllerService(new ServicioSMS());
        controllerService.recibirNotificacion();
    }


}
