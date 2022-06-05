package repository;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class CocheRepository_Factory implements Factory<CocheRepository> {
  @Override
  public CocheRepository get() {
    return newInstance();
  }

  public static CocheRepository_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static CocheRepository newInstance() {
    return new CocheRepository();
  }

  private static final class InstanceHolder {
    private static final CocheRepository_Factory INSTANCE = new CocheRepository_Factory();
  }
}
