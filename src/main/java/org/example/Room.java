package org.example;

import org.example.characters.*;
import org.example.enums.Emotion;

import java.util.LinkedList;
import java.util.List;

public class Room {
    private final LinkedList<Human> people = new LinkedList<Human>();
    private final String name;

    public Room(String n){
        name = n;
    }

    public Room(String n, Human[] crowd){
        name = n;
        people.addAll(List.of(crowd));
    }

    public String getName(){
        return name;
    }

    public void addPerson(Human human){
        if (human.getPosition() == null) System.out.println(human.getName() + " зашел в: " + getName() + ".");
        for (Human man: people){
            if (man.isFriend(human)) man.react(Emotion.HAPPY, human);
            else man.react(Emotion.JEALOUS, human);
        }
        people.add(human);
    }

    public LinkedList<Human> getPeople() {
        return people;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result += people.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) { return true; }
        if (obj == null || this.getClass() != obj.getClass()) { return false; }
        Room room = (Room) obj;
        if (! this.getName().equals(room.getName())) { return false; }
        return this.getPeople().equals(room.getPeople());
    }

    @Override
    public String toString() {
        return name;
    }
}
