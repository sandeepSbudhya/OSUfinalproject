package com.springbootkafka.producer.services;

import java.util.concurrent.CompletableFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.springbootkafka.producer.types.StopMessage;

@Service
public class ProduceStopMessage{
    
    @Autowired
    private KafkaTemplate<String, Object> template;
    
    /**
     * 
     * @param topic Topic to which the message needs to be pushed
     * @param message   The message
     */
    public void sendStopToPerformanceMessageTopic(StopMessage stopMessage) {
    
        CompletableFuture<SendResult<String, Object>> futureMessage = template.send("performance-messages", stopMessage);
        futureMessage.whenComplete((result, exception)->{
            if(exception == null) {
                System.out.println("sent performance message successfully");
                return;
            }
            System.out.println("failed to send performance message");
        });
    }
}