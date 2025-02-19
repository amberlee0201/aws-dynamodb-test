# DynamoDB + AWS SDK for Java 2.x + Spring Boot

## 1. DynamoDBEnhancedClient 사용
DynamoDBEnhancedClient 객체 기반 API 제공, 엔터티 매핑을 자동으로 처리

## 2. application.properties 설정
필요한 설정 값들

```properties
aws.dynamodb.region=
aws.dynamodb.table-name=
aws.dynamodb.access-key=
aws.dynamodb.secret-key=
```

## 3. DynamoDB 기본 키 구조

- **파티션 키 (Partition Key)**: `room_id` (String)
- **정렬 키 (Sort Key)**: `message_id` (String)

## 4. 주의사항
ClassLoader와 관련된 이슈가 발생할 수 있으므로 Spring Boot DevTools 비활성화

