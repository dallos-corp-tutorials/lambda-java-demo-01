package lambda.java.lab.repository;

import lambda.java.lab.model.LambdaModel;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.PutItemSpec;
import com.google.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class LambdaDynamoDbRepositoryImpl implements ILambdaDynamoDbRepository {

  private static final Logger LOGGER = LoggerFactory.getLogger(LambdaDynamoDbRepositoryImpl.class);
  private static final String DYNAMO_DB_TABLE_NAME = "lambda-java-lab";
  @Inject private DynamoDB dynamoDB;

  @Override
  public String save(LambdaModel lambdaModel) {
    LOGGER.info("Start save() LambdaDynamoDbRepositoryImpl");
    Table table = dynamoDB.getTable(DYNAMO_DB_TABLE_NAME);
    PutItemOutcome outcome = table.putItem(new PutItemSpec().withItem(
    new Item().withString("lambda-java-lab-id", java.util.UUID.randomUUID().toString())
            .withString("lambda-name", "lambda-name-lab-4:35")));
    LOGGER.info("End save() LambdaDynamoDbRepositoryImpl: {} ", outcome);
    return "Test Java Lambda";
  }
}
