package com.springbootkafka.producer.controllers;

import com.springbootkafka.producer.services.ProduceMessage;
import com.springbootkafka.producer.types.ProduceToTopic;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Controller to process producer message pushes
 */
@RestController
@RequestMapping("/")
public class ProduceMessageController {

    @Autowired
    private ProduceMessage produceMessage;

    /**
     * 
     * @param produceToTopic convert JSON body to java object
     * @return
     */
    @PostMapping("/producer")
    public ResponseEntity<String> produceMessage(@RequestBody ProduceToTopic produceToTopic) {
        try{
            produceMessage.sendMessageToTopic(produceToTopic.getTopic(), produceToTopic.getMessage());
            return ResponseEntity.ok("successfully sent message: "+produceToTopic.getMessage());
        } catch (Exception e) {
            System.out.println("Could not send message: "+produceToTopic.getMessage());
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
}
