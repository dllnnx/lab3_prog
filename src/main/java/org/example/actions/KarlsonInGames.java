package org.example.actions;

import org.example.characters.Karlson;
import org.example.characters.Malysh;
import org.example.characters.Opinion;
import org.example.enums.Confidence;
import org.example.enums.EventType;
import org.example.enums.Rate;

public class KarlsonInGames implements Action{
    private final Malysh malysh;
    private final Karlson karlson;

    public KarlsonInGames(Malysh malysh, Karlson karlson) {
        this.malysh = malysh;
        this.karlson = karlson;
    }

    @Override
    public void run(){
        Opinion.addOpinion(malysh, new Opinion(Confidence.PROBABLY, Rate.BEST, karlson, EventType.PLAY));
    }

    @Override
    public String getState() {
        return "И уж наверняка он самый лучший в мире товарищ по играм.";
    }
}
