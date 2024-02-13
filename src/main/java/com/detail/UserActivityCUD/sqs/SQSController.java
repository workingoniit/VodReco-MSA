package com.detail.UserActivityCUD.sqs;

import io.awspring.cloud.sqs.operations.SqsTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class SQSController {
    private final AmazonSQSSender amazonSQSSender;
    private final SqsTemplate template;
    @Value("${application.amazon.sqs.queue-name}")
    private String queueName;

    @PostMapping(value = "/send") // TODO : 테스트용, 추후 삭제
    public void sendMessage(){
//        GroupID로 중복 제거
        amazonSQSSender.sendMessage(queueName, UUID.randomUUID().toString(), "Send message test");
        System.out.println("success");
    }
}
