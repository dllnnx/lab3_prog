package org.example;

import org.example.actions.*;
import org.example.characters.*;
import org.example.enums.EventType;
import org.example.enums.Position;

import java.util.LinkedList;

public class Story {
    private final Room roomMalysh = new Room();
    private final Human malysh = new Human("Малыш");
    private final Human karlson = new Human("Карлсон");
    private final Human krister = new Human("Кристер");
    private final Human gunilla = new Human("Гунилла");

    public void prepare(){
        roomMalysh.setName("комната Малыша");
        malysh.setPosition(Position.LIE);
        roomMalysh.addPerson(malysh);

        Event.addEvents(malysh, new Event(karlson, EventType.PAINT), new Event(karlson, EventType.PLAY),
                new Event(karlson, EventType.CLEANUP));
        Event.addEvents(malysh, new Event(krister, EventType.BRAG));

    }

    public void go(){
        LinkedList<Action> actions = new LinkedList<>();
        actions.add(new PersonComesInTheRoom(malysh, roomMalysh, karlson));
        actions.add(new PersonIsConfident(malysh, karlson));
        actions.add(new PersonInGames(malysh, karlson));
        actions.add(new PersonThinksAboutFriends(malysh, krister));
        actions.add(new PersonBrags(malysh, gunilla, krister));


//        actions.forEach((action -> {
//            action.run();
//            System.out.println(action.getState() + "\n");
//        }));
//        for (int i = 0; i < 3; i++){
//            actions.get(i).run();
//        }
        actions.forEach(Action::run);
    }

}
