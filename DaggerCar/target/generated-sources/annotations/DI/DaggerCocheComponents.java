package DI;

import controllers.CocheController;
import controllers.CocheController_Factory;
import dagger.internal.DaggerGenerated;
import javax.annotation.processing.Generated;
import repository.CocheRepository_Factory;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DaggerCocheComponents {
  private DaggerCocheComponents() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static CocheComponents create() {
    return new Builder().build();
  }

  public static final class Builder {
    private Builder() {
    }

    public CocheComponents build() {
      return new CocheComponentsImpl();
    }
  }

  private static final class CocheComponentsImpl implements CocheComponents {
    private final CocheComponentsImpl cocheComponentsImpl = this;

    private CocheComponentsImpl() {


    }

    @Override
    public CocheController build() {
      return CocheController_Factory.newInstance(CocheRepository_Factory.newInstance());
    }
  }
}
