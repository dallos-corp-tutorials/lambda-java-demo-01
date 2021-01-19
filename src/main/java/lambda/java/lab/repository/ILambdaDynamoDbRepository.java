package lambda.java.lab.repository;

import lambda.java.lab.model.LambdaModel;

public interface ILambdaDynamoDbRepository {
    String save(final LambdaModel lambdaModel);
}
