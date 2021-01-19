package lambda.java.lab.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;

public class ComponentsConfig extends AbstractModule {

  @Provides
  public Gson gson() {
    return new GsonBuilder().create();
  }
}
