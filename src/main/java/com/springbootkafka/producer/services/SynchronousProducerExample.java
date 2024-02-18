package com.springbootkafka.producer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
public class SynchronousProducerExample {
    @Autowired
    private ProduceMessage produceMessage;

    @Scheduled(fixedRate = 20000)
    public void callProducer() throws InterruptedException{
        System.out.println("This service pushes numbers from zero to nine with one second delay to the producer every 20 seconds.");
        for(int i = 0 ; i < 10 ; i++) {
            produceMessage.sendMessageToTopic("record-numbers", Integer.toString(i));
            Thread.sleep((long) 1000 , 0);
        }
        System.out.println("Done pushing numbers to topic.");
    }
}
