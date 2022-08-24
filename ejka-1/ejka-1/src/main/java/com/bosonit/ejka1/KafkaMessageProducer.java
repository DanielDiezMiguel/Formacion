package com.bosonit.ejka1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
public class KafkaMessageProducer {

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @Value("${message.topic.name}")
    private String topicName;

    public void sendMessage(String topic, String message) {
        if (topicName == null || topic.trim().equals("")) {
            topic = topicName;
            ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, message);
            future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
                @Override
                public void onFailure(Throwable ex) {
                    System.out.println("Unable to send MESSAGE: " + message + " due to: " + ex.getMessage());
                }

                @Override
                public void onSuccess(SendResult<String, String> result) {
                    System.out.println("SENT MESSAGE: " + message);
                }
            });
        }
    }

}
