package com.springbootkafka.producer.types;

public class CreateTopicMessage {
    String topic;

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTopic() {
        return this.topic;
    }
}
