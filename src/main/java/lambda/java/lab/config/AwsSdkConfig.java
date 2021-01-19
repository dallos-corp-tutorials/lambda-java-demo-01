package lambda.java.lab.config;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;

public class AwsSdkConfig extends AbstractModule {

  @Provides
  public DynamoDB dynamoDB() {
    return new DynamoDB(clientDynamoDB());
  }

  @Provides
  public AmazonDynamoDB clientDynamoDB() {
    return AmazonDynamoDBClientBuilder.standard().build();
  }
}
