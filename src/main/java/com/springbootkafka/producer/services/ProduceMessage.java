package com.springbootkafka.producer.services;

import java.util.concurrent.CompletableFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

/**
 * Service to produce a message to a topic
 */
@Service
public class ProduceMessage {
    @Autowired
    private KafkaTemplate<String, Object> template;

    /**
     * 
     * @param topic Topic to which the message needs to be pushed
     * @param message   The message
     */
    public void sendMessageToTopic(String topic, String message) {

        CompletableFuture<SendResult<String, Object>> futureMessage = template.send(topic, message);
        futureMessage.whenComplete((result, exception)->{
            if(exception == null) {
                System.out.println("success");
                return;
            }
            System.out.println("failure");
        });
    }
}
