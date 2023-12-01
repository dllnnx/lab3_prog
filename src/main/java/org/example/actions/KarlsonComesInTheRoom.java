package org.example.actions;

import org.example.Room;
import org.example.characters.Karlson;
import org.example.characters.Malysh;
import org.example.enums.Position;

public class KarlsonComesInTheRoom implements Action{
    private final Malysh malysh;
    private final Room roomMalysh;
    private final Karlson karlson;


    public KarlsonComesInTheRoom(Malysh malysh, Room roomMalysh, Karlson karlson){
        this.karlson = karlson;
        this.malysh = malysh;
        this.roomMalysh = roomMalysh;
    }

    @Override
    public void run() {
        malysh.printState();
        roomMalysh.addPerson(karlson);
        malysh.setPosition(Position.UP);
    }

    @Override
    public String getState() {
        return "Малыш вскочил на ноги и стоял, не помня себя от восторга: так он был рад, что Карлсон вернулся.";
    }
}
