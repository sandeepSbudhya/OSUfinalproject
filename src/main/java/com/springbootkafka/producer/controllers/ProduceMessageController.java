package com.springbootkafka.producer.controllers;

import com.springbootkafka.producer.services.ProducePerformanceMessage;
import com.springbootkafka.producer.services.ProduceProgressMessage;
import com.springbootkafka.producer.services.ProduceStopMessage;
import com.springbootkafka.producer.types.PerformanceMessage;
import com.springbootkafka.producer.types.ProgressMessage;
import com.springbootkafka.producer.types.StopMessage;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Controller to process producer message pushes
 */
@RestController
@RequestMapping("/producemessage")
public class ProduceMessageController {

    @Autowired
    private ProducePerformanceMessage producePerformanceMessage;

    @Autowired
    private ProduceProgressMessage produceProgressMessage;

    @Autowired
    private ProduceStopMessage produceStopMessage;

    /**
     * 
     * @param performanceMessage convert JSON body to java object
     * @return
     */
    @PostMapping("/performance")
    public ResponseEntity<String> sendPerformanceMessage(@RequestBody PerformanceMessage performanceMessage) {
        try{
            producePerformanceMessage.sendToPerformanceMessagesTopic(performanceMessage);
            return ResponseEntity.ok("successfully sent message: "+performanceMessage.toString());
        } catch (Exception e) {
            System.out.println("Could not send message: "+performanceMessage.toString());
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * 
     * @param progressMessage convert JSON body to java object
     * @return
     */
    @PostMapping("/progress")
    public ResponseEntity<String> sendProgressMessage(@RequestBody ProgressMessage progressMessage) {
        try{
            produceProgressMessage.sendToProgressMessagesTopic(progressMessage);
            return ResponseEntity.ok("successfully sent message: "+progressMessage.toString());
        } catch (Exception e) {
            System.out.println("Could not send message: "+progressMessage.toString());
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/stop")
    public ResponseEntity<String> sendStopMessage(@RequestBody StopMessage stopMessage) {
        try{
            produceStopMessage.sendStopToPerformanceMessageTopic(stopMessage);
            return ResponseEntity.ok("successfully sent message: "+stopMessage.toString());
        } catch (Exception e) {
            System.out.println("Could not send message: "+stopMessage.toString());
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
}
