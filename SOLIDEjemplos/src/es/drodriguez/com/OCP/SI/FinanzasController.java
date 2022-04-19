package es.drodriguez.com.OCP.SI;


public class FinanzasController {
    private Reportar reportar;


    //Inyectamos la dependencia a través del constructor
    public FinanzasController(Reportar reportar){
        this.reportar = reportar;
    }

    public void reporte(){
        reportar.prestar();
    }

    public static void main(String[] args){
        FinanzasController finanzasController = new FinanzasController(new WebReporta());
        finanzasController.reporte();

        FinanzasController finanzasController1 = new FinanzasController(new XMLReportar());
        finanzasController1.reporte();
    }
}
