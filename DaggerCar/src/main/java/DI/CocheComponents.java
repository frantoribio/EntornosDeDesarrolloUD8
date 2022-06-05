package DI;

import controllers.CocheController;
import dagger.Component;


@Component(modules = {CocheModule.class})
public interface CocheComponents {
    CocheController build();
}
