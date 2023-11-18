package org.example;

import org.example.characters.*;
import org.example.enums.Confidence;
import org.example.enums.EventType;
import org.example.enums.Position;
import org.example.enums.Rate;

public class Story {
    private final Room roomMalysh = new Room();
    private final Malysh malysh = new Malysh("Малыш");
    private final Karlson karlson = new Karlson("Карлсон");
    private final Krister krister = new Krister("Кристер");
    private final Gunilla gunilla = new Gunilla("Гунилла");

    public Story() {}


    public void prepare(){
        roomMalysh.setName("комната Малыша");
        malysh.setPosition(Position.LIE);
        malysh.setLocation(roomMalysh);

        Event.addEvents(malysh, new Event(karlson, EventType.PAINT), new Event(karlson, EventType.PLAY),
                new Event(karlson, EventType.CLEANUP));
        Event.addEvents(malysh, new Event(krister, EventType.BRAG));

    }


    public void karlsonIn(){
        // Малыш вскочил на ноги и стоял, не помня себя от восторга: так он был рад, что Карлсон вернулся.

        malysh.printState();
        roomMalysh.addPerson(karlson);
        malysh.setPosition(Position.UP);
    }

    public void malyshConf(){
        // Малыш не сомневался, что Карлсон во всем "лучший в мире".

        Opinion.addOpinion(malysh, new Opinion(Confidence.DEFINITELY, Rate.BEST, karlson, EventType.EVERYTHING));
    }

    public void karlsonInGames(){
        //  И уж наверняка он самый лучший в мире товарищ по играм.

        Opinion.addOpinion(malysh, new Opinion(Confidence.PROBABLY, Rate.BEST, karlson, EventType.PLAY));
    }

    public void malyshThinkOfFriends(){
        //  Правда, Кристер, и Гунилла тоже хорошие товарищи, но им далеко до Карлсона, который живет на крыше!

        Opinion.addOpinion(malysh, new Opinion(Confidence.DEFINITELY, Rate.GOOD, krister, EventType.BEFRIEND));
    }

    public void kristerBrags(){
        // Кристер только и делает, что хвалится своей собакой Еффой, и Малыш ему давно завидует.

        Opinion.addOpinion(malysh, new Opinion(Confidence.DEFINITELY, Rate.GOOD, gunilla, EventType.BEFRIEND));

        krister.brag("собакой Еффой", malysh);
    }
}
