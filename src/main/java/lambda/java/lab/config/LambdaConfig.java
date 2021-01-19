package lambda.java.lab.config;

import lambda.java.lab.repository.ILambdaDynamoDbRepository;
import lambda.java.lab.repository.LambdaDynamoDbRepositoryImpl;
import lambda.java.lab.service.ILambdaService;
import lambda.java.lab.service.LambdaServiceImpl;
import com.google.inject.AbstractModule;

public class LambdaConfig extends AbstractModule {

  @Override
  protected void configure() {
    bind(ILambdaService.class).to(LambdaServiceImpl.class);
    bind(ILambdaDynamoDbRepository.class).to(LambdaDynamoDbRepositoryImpl.class);
  }

}
