package org.example.enums;

public enum Emotion {
    HAPPY("рад"),
    CALM("спокоен"),
    JEALOUS("завидует");

    private String emotion;

    Emotion(String emotion){
        this.emotion = emotion;
    }
    public String getEmotion() {
        return emotion;
    }

}
