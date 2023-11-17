package org.example.characters;

import org.example.*;
import org.example.enums.*;

import java.util.List;

import java.util.LinkedList;

public abstract class Human implements Reaction {
    protected String name;
    protected Position position;
    protected Emotion emotion = Emotion.CALM;
    protected Room location;
    protected List<Event> events = new LinkedList<Event>();
    protected List<List> opinions = new LinkedList<>();

    public Human(String name) {
        this.name = name;
    }

    public Human(String name, Position position) {
        this.name = name;
        this.position = position;
        System.out.println(name + " " + position.getPosition() + ".");
    }

    public Human(String name, Position position, Room location) {
        this.name = name;
        this.position = position;
        this.location = location;
        location.addPerson(this);
        System.out.println(name + " " + position.getPosition() + " в: " + location.getName() + ".");
    }

    public Human(String name, Room location) {
        this.name = name;
        this.location = location;
        System.out.println(name + " в: " + location.getName() + ".");
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(Position position) {
        this.position = position;
        System.out.println(this.getName() + " " + position.getPosition() + ".");
    }
    public Position getPosition() {
        return position;
    }

    public Emotion getEmotion() {
        return emotion;
    }
    public void setEmotion(Emotion emotion) {
        this.emotion = emotion;
        System.out.println(this.getName() + " " + emotion.getEmotion() + ".");
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(LinkedList<Event> events) {
        this.events = events;
    }



    @Override
    public void react(Emotion emotion, Human human) {
        this.emotion = emotion;
        System.out.println(this.getName() + " " + this.getEmotion().getEmotion() + " " + human.getName() + "у.");
    }

    public void say(String phrase){
        System.out.println(phrase);
    }

    public void moveTo(Room room){
        room.addPerson(this);
    }

    public void changePosition(Position newPos){
        this.setPosition(newPos);
    }

    public void addEvent(Event event){
        events.add(event);
    }

    public void addEvents(Event... events1){
        events.addAll(List.of(events1));
    }

    public void addOpinion(Confidence confidence, Rate rate, Human human, EventType eventType){
        opinions.add(List.of(confidence, rate, human, eventType));
        System.out.println(this.getName() + " " + confidence.getTitle() + " " + human.getName() + " " +
                rate.getTitle() + " в: " + eventType.getTitle() + ".");
    }

    public boolean isFriend(Human human){
        int friendCnt = 0;
        for (Event e: this.events){
            if (e.getHuman().equals(human)){
                if (e.getType().getRate().equals("хорошо")) friendCnt++;
                else friendCnt--;
            }
        }
        return (friendCnt >= 0);
    }

//    public void thinkOf(Human human){
//        int goodThought = 0;
//        for (Event e: this.events){
//            if (e.getHuman().equals(human)){
//                if (e.getType().getRate().equals("хорошо")) goodThought++;
//                else goodThought--;
//            }
//        }
//        if (goodThought >= 0) this.react(Emotion.HAPPY, human);
//        else this.react(Emotion.JEALOUS, human);
//    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()){ return false; }
        Human human = (Human) obj;
        if (! this.getName().equals((human.getName()))) { return false; }
        if (! this.getPosition().equals(human.getPosition())) { return false; }
        if (! this.getEmotion().equals(human.getEmotion())) { return false; }
        return this.getEvents().equals(human.getEvents());
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result += position.hashCode() + emotion.hashCode() + location.hashCode() + events.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return name;
    }
}
