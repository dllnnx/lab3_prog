package org.example.actions;

import org.example.characters.Karlson;
import org.example.characters.Malysh;
import org.example.characters.Opinion;
import org.example.enums.Confidence;
import org.example.enums.EventType;
import org.example.enums.Rate;

public class MalyshIsConfident implements Action{

    private final Malysh malysh;
    private final Karlson karlson;

    public MalyshIsConfident(Malysh malysh, Karlson karlson) {
        this.malysh = malysh;
        this.karlson = karlson;
    }

    @Override
    public void run() {
        Opinion.addOpinion(malysh, new Opinion(Confidence.DEFINITELY, Rate.BEST, karlson, EventType.EVERYTHING));
    }

    @Override
    public String getState() {
        return "Малыш не сомневался, что Карлсон во всем \"лучший в мире\"";
    }
}
