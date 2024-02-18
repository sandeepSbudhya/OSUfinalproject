package com.springbootkafka.producer.types;

public class ProduceToTopic {
    private String topic;
    private String message;
    
    public ProduceToTopic(String topic, String message) {
        this.topic = topic;
        this.message = message;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTopic() {
        return this.topic;
    }

    public String getMessage() {
        return this.message;
    }
}
