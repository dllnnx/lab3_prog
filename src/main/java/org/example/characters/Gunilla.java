package org.example.characters;

import org.example.Room;
import org.example.enums.Position;

public class Gunilla extends Human{
    public Gunilla(String name) {
        super(name);
    }

    public Gunilla(String name, Position position) {
        super(name, position);
    }

    public Gunilla(String name, Position position, Room location) {
        super(name, position, location);
    }

    public Gunilla(String name, Room location) {
        super(name, location);
    }
}
