package org.example.characters;

import org.example.Room;
import org.example.enums.Emotion;
import org.example.enums.Position;

public class Krister extends Human{

    public Krister(String name) {
        super(name);
    }

    public Krister(String name, Position position) {
        super(name, position);
    }

    public Krister(String name, Position position, Room location) {
        super(name, position, location);
    }

    public Krister(String name, Room location) {
        super(name, location);
    }

    public void brag(String s, Human human){
        System.out.println(this.getName() + " хвастается " + s + ".");
        human.setEmotion(Emotion.JEALOUS);
    }
}
