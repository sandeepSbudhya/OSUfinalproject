package com.springbootkafka.producer.types;

/**
 * An example of what a performance message could look like
 */
public class PerformanceMessage {
    private float accuracy, fmeasure, precission, recall;
    private int userId;
    
    public PerformanceMessage(float accuracy, float fmeasure, float precission, float recall, int userId) {
        this.accuracy = accuracy;
        this.fmeasure = fmeasure;
        this.precission = precission;
        this.recall = recall;
        this.userId = userId;
    }

    public void setAccuracy(float accuracy) {
        this.accuracy = accuracy;
    }

    public void setFmeasure(float fmeasure) {
        this.fmeasure = fmeasure;
    }

    public void setPrecission(float precission) {
        this.precission = precission;
    }

    public void setRecall(float recall) {
        this.recall = recall;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public float getAccuracy() {
        return this.accuracy;
    }

    public float getFmeasure() {
        return this.fmeasure;
    }

    public float getPrecission() {
        return this.precission;
    }

    public float getRecall() {
        return this.recall;
    }

    public int getUserId() {
        return this.userId;
    }
}
