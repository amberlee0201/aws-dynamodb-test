package test.dynamo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;

@Configuration
public class DynamoDBConfig {

    @Value("${aws.dynamodb.region}")
    private String region;

    @Value("${aws.dynamodb.access-key}")
    private String accessKey;

    @Value("${aws.dynamodb.secret-key}")
    private String secretKey;

    @Bean
    public DynamoDbClient dynamoDbClient() {
        return DynamoDbClient.builder()
                .region(Region.of(region))
                .credentialsProvider(
                        StaticCredentialsProvider.create(AwsBasicCredentials.create(accessKey, secretKey))
                )
                .build();
    }

    @Bean
    public DynamoDbEnhancedClient dynamoDbEnhancedClient(DynamoDbClient dynamoDbClient){
        return DynamoDbEnhancedClient.builder().dynamoDbClient(dynamoDbClient).build();
    }
}
