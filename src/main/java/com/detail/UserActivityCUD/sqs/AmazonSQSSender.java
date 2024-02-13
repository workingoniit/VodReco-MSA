package com.detail.UserActivityCUD.sqs;

import io.awspring.cloud.sqs.operations.SendResult;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;

@Component
@RequiredArgsConstructor
public class AmazonSQSSender {

    private final SqsTemplate template;

    @Value("${application.amazon.sqs.queue-name}")
    private String queueName;

    @Autowired
    public AmazonSQSSender(SqsAsyncClient sqsAsyncClient) {
        this.template = SqsTemplate.newTemplate(sqsAsyncClient);
    }

    public SendResult<String> sendMessage(String queueName, String groupId, String message) {
        System.out.println("Sender: " + message);
        return template.send(to -> to
                .queue(queueName)
                .messageGroupId(groupId)
                .messageDeduplicationId(groupId)
                .payload(message));
    }


}