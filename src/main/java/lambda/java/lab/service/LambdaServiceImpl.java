package lambda.java.lab.service;

import lambda.java.lab.model.LambdaModel;
import lambda.java.lab.repository.ILambdaDynamoDbRepository;
import com.google.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LambdaServiceImpl implements ILambdaService{

    private static final Logger LOGGER = LoggerFactory.getLogger(LambdaServiceImpl.class);

    @Inject private ILambdaDynamoDbRepository lambdaDynamoDbRepository;

    @Override
    public String save(LambdaModel lambdaModel) {
        LOGGER.info("Start save() LambdaServiceImpl");
        final String content = lambdaDynamoDbRepository.save(lambdaModel);
        LOGGER.info("Start end() LambdaServiceImpl: {}", content);
        return content;
    }
}
