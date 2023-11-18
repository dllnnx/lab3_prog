package org.example;

import org.example.characters.*;
import org.example.enums.Emotion;

import java.util.LinkedList;
import java.util.List;

public class Room {
    private LinkedList<Human> people = new LinkedList<Human>();
    private String name;

    public Room(String n){
        name = n;
    }

    public Room(String n, Human[] crowd){
        name = n;
        people.addAll(List.of(crowd));
    }

    public Room(){}

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedList<Human> getPeople() {
        return people;
    }

    public void addPerson(Human human){
        System.out.println(human.getName() + " зашел в: " + getName() + ".");
        for (Human man: people){
            if (Friends.isFriend(man, human)) man.react(Emotion.HAPPY, human);
            else man.react(Emotion.JEALOUS, human);
        }
        people.add(human);
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
