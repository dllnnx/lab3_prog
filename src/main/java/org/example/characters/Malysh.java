package org.example.characters;

import org.example.Room;
import org.example.enums.Position;

public class Malysh extends Human {
    public Malysh(String name) {
        super(name);
    }

    public Malysh(String name, Position position) {
        super(name, position);
    }

    public Malysh(String name, Position position, Room location) {
        super(name, position, location);
    }

    public Malysh(String name, Room location) {
        super(name, location);
    }

}
