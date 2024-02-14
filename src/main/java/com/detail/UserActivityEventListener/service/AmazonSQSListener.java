package com.detail.UserActivityEventListener.service;

import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AmazonSQSListener {

    private final MessageClassifier messageClassifier;

    @SqsListener("${application.amazon.sqs.queue-name}")
    public void messageListener(String message) {
        System.out.println("Listener: " + message);
        messageClassifier.classifyMessage(message);
    }

}