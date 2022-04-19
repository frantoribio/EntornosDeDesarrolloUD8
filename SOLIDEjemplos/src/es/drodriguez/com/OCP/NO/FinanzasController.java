package es.drodriguez.com.OCP.NO;

public class FinanzasController {
    private TipoReporte tipoReporte;
    private Reporte reporte;

    //Inyección de dependencias por constructor
    public FinanzasController(TipoReporte tipoReporte){
        this.tipoReporte = tipoReporte;
    }
    public void reportar(){
        switch(this.tipoReporte){
            case WEB:
                reporte = new WebReporte();
                break;
            case XML:
                reporte = new XMLReporte();
                break;
        }
        if (this.tipoReporte == TipoReporte.WEB){
            ((WebReporte) reporte).prestar();

        } else {
            ((XMLReporte)reporte).print();
        }
    }

    public static void main(String[] args){
        //En el caso de que sea de tipo Web
        FinanzasController finanzasController = new FinanzasController(TipoReporte.WEB);
        finanzasController.reportar();

        //En el caso de que sea tipo XML
        FinanzasController finanzasController2 = new FinanzasController(TipoReporte.XML);
        finanzasController2.reportar();

    }
}
