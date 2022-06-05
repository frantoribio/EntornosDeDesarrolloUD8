package controllers;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import repository.ICocheRepository;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class CocheController_Factory implements Factory<CocheController> {
  private final Provider<ICocheRepository> cochesProvider;

  public CocheController_Factory(Provider<ICocheRepository> cochesProvider) {
    this.cochesProvider = cochesProvider;
  }

  @Override
  public CocheController get() {
    return newInstance(cochesProvider.get());
  }

  public static CocheController_Factory create(Provider<ICocheRepository> cochesProvider) {
    return new CocheController_Factory(cochesProvider);
  }

  public static CocheController newInstance(ICocheRepository coches) {
    return new CocheController(coches);
  }
}
