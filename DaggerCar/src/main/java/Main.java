import DI.CocheComponents;
import DI.DaggerCocheComponents;
import models.Coche;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hola Iniciando ejemplos de Dagger");
        Coche coche1 = new Coche("COCHE 1");
        Coche coche2 = new Coche("COCHE 2");
        CocheComponents cocheComponents = DaggerCocheComponents.create();
        var controlador = cocheComponents.build();
        controlador.saveCoche(coche1);
        controlador.saveCoche(coche2);
        System.out.println(controlador.getAll());
    }
}

