package DI;

import dagger.Binds;
import dagger.Module;
import repository.CocheRepository;
import repository.ICocheRepository;

@Module
public interface CocheModule {
    @Binds
    ICocheRepository provide(CocheRepository repository);
}
