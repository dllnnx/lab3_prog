package org.example;

import org.example.characters.*;
import org.example.enums.*;

import javax.security.auth.login.Configuration;
import java.sql.Array;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    public static void main(String[] args) {

        Room roomMalysh = new Room("комната Малыша");
        Malysh malysh = new Malysh("Малыш", Position.LIE, roomMalysh);
        Karlson karlson = new Karlson("Карлсон");
        Krister krister = new Krister("Кристер");
        Gunilla gunilla = new Gunilla("Гунилла");

        malysh.addEvents(new Event(karlson, EventType.PAINT), new Event(karlson, EventType.PLAY),
                new Event(karlson, EventType.CLEANUP));
        malysh.addEvents(new Event(krister, EventType.BRAG));

        karlson.moveTo(roomMalysh);
        malysh.changePosition(Position.UP);

        malysh.addOpinion(Confidence.DEFINITELY, Rate.BEST, karlson, EventType.EVERYTHING);
        malysh.addOpinion(Confidence.PROBABLY, Rate.BEST, karlson, EventType.PLAY);
        malysh.addOpinion(Confidence.DEFINITELY, Rate.GOOD, krister, EventType.BEFRIEND);
        malysh.addOpinion(Confidence.DEFINITELY, Rate.GOOD, gunilla, EventType.BEFRIEND);

        krister.brag("собакой Еффой", malysh);

    }
}