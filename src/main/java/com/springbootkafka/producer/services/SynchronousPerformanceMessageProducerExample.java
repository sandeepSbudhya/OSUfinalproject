package com.springbootkafka.producer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.springbootkafka.producer.types.PerformanceMessage;

@Service
@EnableScheduling
public class SynchronousPerformanceMessageProducerExample {
    @Autowired
    private ProducePerformanceMessage producePerformanceMessage;

    @Scheduled(fixedRate = 30000)
    public void callProducer() throws InterruptedException{
        System.out.println("This service pushes performance measures every 2 seconds for 20 seconds, then takes a 10 second break.");
        for(int i = 0 ; i < 10 ; i++) {
            PerformanceMessage performanceMessage = new PerformanceMessage(i/12, i/11, i/10, i/10, 1);
            producePerformanceMessage.sendToPerformanceMessagesTopic(performanceMessage);
            Thread.sleep((long) 2000 , 0);
        }
        System.out.println("Done pushing messages to topic.");
    }
}
