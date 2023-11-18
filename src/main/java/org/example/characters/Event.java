package org.example.characters;

import org.example.enums.EventType;

import java.util.List;

public class Event {
    Human human;
    EventType type;

    public Event(Human human, EventType type) {
        this.human = human;
        this.type = type;
    }

    public Human getHuman() {
        return human;
    }

    public void setHuman(Human human) {
        this.human = human;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public static void addEvents(Human human, Event... events1){
        human.events.addAll(List.of(events1));
    }
}
