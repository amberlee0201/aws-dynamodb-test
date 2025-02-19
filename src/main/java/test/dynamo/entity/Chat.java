package test.dynamo.entity;

import lombok.*;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;


@DynamoDbBean
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@ToString
public class Chat {
    private String roomId;
    private String messageId;
    private String userId;
    private String content;
    private String timestamp;

    @DynamoDbPartitionKey
    @DynamoDbAttribute("room_id")
    public String getRoomId() {
        return roomId;
    }

    @DynamoDbSortKey
    @DynamoDbAttribute("message_id")
    public String getMessageId() {
        return messageId;
    }

    @DynamoDbAttribute("user_id")
    public String getUserId() {
        return userId;
    }

    @DynamoDbAttribute("content")
    public String getContent() {
        return content;
    }

    @DynamoDbAttribute("timestamp")
    public String getTimestamp() {
        return timestamp;
    }

}
