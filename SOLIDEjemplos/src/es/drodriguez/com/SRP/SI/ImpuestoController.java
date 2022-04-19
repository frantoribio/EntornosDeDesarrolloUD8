package es.drodriguez.com.SRP.SI;

public class ImpuestoController {
    Repository repository;
    ServicioEmail servicioEmail;

    /*
    Uno de otros patrones de SOLID es el de Inyección por Dependencias, usamos un constructor para inyectar las dependencias,
    de esta forma no es necesario que utilicemos el instance
     */

    public ImpuestoController(Repository repository, ServicioEmail servicioEmail){
        this.repository = repository;
         this.servicioEmail = servicioEmail;
    }

    //Tasas de impuesto
    public void trabajoTasasImpuestos(){
        System.out.println("Realizando acciones con impuestos");
    }

    //La Base de Datos es ahora quien tiene la responsabilidad de guardar los datos/cambios
    public void guadarBBDD(){
        this.repository.guardar();
    }

    //Ahora quien envía el mail es el servicio de mail que hemos creado, por lo tanto le damos la responsabilidad
    public void servicioEmail(){
        this.servicioEmail.enviarEmail();
    }

    public static void main(String[] args){
        //Desde nuestro main llamamos a nuestro repositorio y al servicio de email
        final Repository repository = new Repository();
        final  ServicioEmail servicioEmail = new ServicioEmail();
        ImpuestoController iC = new ImpuestoController(repository, servicioEmail);
        iC.trabajoTasasImpuestos();
        iC.guadarBBDD();
        iC.servicioEmail();
    }
}
