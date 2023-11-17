package org.example;

import org.example.characters.Human;
import org.example.enums.EventType;

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
}
