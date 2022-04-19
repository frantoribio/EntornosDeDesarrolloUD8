package es.drodriguez.com.SRP.NO;

public class ImpuestosController {
    //Controlar Tasas de Impuestos
    public void trabajoTasasImpuestos(){
        System.out.println("Realizando acciones con impuestos");
    }

    //Uso de la base de datos
    public void guardarCambios(){
        System.out.println("Guardando cambios ...");
    }

    //Envío emails
    public void envioMail(){
        System.out.println("Envio mail ...");
    }


    public static void main(String[] args) {
        ImpuestosController nuevo = new ImpuestosController();
        nuevo.trabajoTasasImpuestos();
        nuevo.guardarCambios();
        nuevo.envioMail();
    }

    /*
    No cumplimos con el principio de responsabilidad única, ya que la misma clase está realizando que no le corresponde,
    por ejemplo almacenar los datos en la base de datos sería un controlador del repositorio, enviar un mail sería un
    servicio...
     */

}
