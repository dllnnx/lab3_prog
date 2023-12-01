package org.example.actions;

import org.example.characters.Krister;
import org.example.characters.Malysh;
import org.example.characters.Opinion;
import org.example.enums.Confidence;
import org.example.enums.EventType;
import org.example.enums.Rate;

public class MalyshThinksAboutFriends implements Action{

    private final Malysh malysh;
    private final Krister krister;

    public MalyshThinksAboutFriends(Malysh malysh, Krister krister) {
        this.malysh = malysh;
        this.krister = krister;
    }

    @Override
    public void run() {
        Opinion.addOpinion(malysh, new Opinion(Confidence.DEFINITELY, Rate.GOOD, krister, EventType.BEFRIEND));
    }

    @Override
    public String getState() {
        return "Правда, Кристер, и Гунилла тоже хорошие товарищи, но им далеко до Карлсона, который живет на крыше!";
    }
}
