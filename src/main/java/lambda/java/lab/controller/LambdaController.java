package lambda.java.lab.controller;

import lambda.java.lab.config.AwsSdkConfig;
import lambda.java.lab.config.ComponentsConfig;
import lambda.java.lab.config.LambdaConfig;
import lambda.java.lab.model.LambdaModel;
import lambda.java.lab.service.ILambdaService;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.gson.Gson;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class LambdaController implements RequestHandler<Object, String> {

  private static final Logger LOGGER = LoggerFactory.getLogger(LambdaController.class);
  private Injector injector;
  private Gson gsonBuilder;
  private ILambdaService service;

  @Override
  public String handleRequest(Object input, Context context) {
    LOGGER.info("Start consumer LambdaController");
    bootInjector(new LambdaConfig(), new ComponentsConfig(), new AwsSdkConfig());
    LOGGER.info("Input: {}", this.getGsonBuilder().toJson(input));
    this.service = injectLambdaService();
    this.service.save(
        this.getGsonBuilder().fromJson(this.getGsonBuilder().toJson(input), LambdaModel.class));
    LOGGER.info("End consumer LambdaController");
    return null;
  }

  private ILambdaService injectLambdaService() {
    return this.service == null ? injector.getInstance(ILambdaService.class) : this.service;
  }

  private Gson getGsonBuilder() {
    return gsonBuilder == null ? injector.getInstance(Gson.class) : gsonBuilder;
  }

  private void bootInjector(final Module... modules) {
    if (injector == null) {
      injector = Guice.createInjector(modules);
    }
  }
}
