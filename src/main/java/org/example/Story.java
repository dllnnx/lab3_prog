package org.example;

import org.example.actions.*;
import org.example.characters.*;
import org.example.enums.EventType;
import org.example.enums.Position;

import java.util.LinkedList;

public class Story {
    private final Room roomMalysh = new Room();
    private final Malysh malysh = new Malysh("Малыш");
    private final Karlson karlson = new Karlson("Карлсон");
    private final Krister krister = new Krister("Кристер");
    private final Gunilla gunilla = new Gunilla("Гунилла");

    public void prepare(){
        roomMalysh.setName("комната Малыша");
        malysh.setPosition(Position.LIE);
        malysh.setLocation(roomMalysh);

        Event.addEvents(malysh, new Event(karlson, EventType.PAINT), new Event(karlson, EventType.PLAY),
                new Event(karlson, EventType.CLEANUP));
        Event.addEvents(malysh, new Event(krister, EventType.BRAG));

    }

    public void go(){
        LinkedList<Action> actions = new LinkedList<>();
        actions.add(new KarlsonComesInTheRoom(malysh, roomMalysh, karlson));
        actions.add(new MalyshIsConfident(malysh, karlson));
        actions.add(new KarlsonInGames(malysh, karlson));
        actions.add(new MalyshThinksAboutFriends(malysh, krister));
        actions.add(new KristerBrags(malysh, gunilla, krister));


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
