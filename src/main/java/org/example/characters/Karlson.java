package org.example.characters;

import org.example.Room;
import org.example.enums.Position;

public class Karlson extends Human{
    public Karlson(String name) {
        super(name);
    }

    public Karlson(String name, Position position) {
        super(name, position);
    }

    public Karlson(String name, Position position, Room location) {
        super(name, position, location);
    }

    public Karlson(String name, Room location) {
        super(name, location);
    }

}
