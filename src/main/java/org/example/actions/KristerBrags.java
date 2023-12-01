package org.example.actions;

import org.example.characters.Gunilla;
import org.example.characters.Krister;
import org.example.characters.Malysh;
import org.example.characters.Opinion;
import org.example.enums.Confidence;
import org.example.enums.EventType;
import org.example.enums.Rate;

public class KristerBrags implements Action{
    private final Malysh malysh;
    private final Gunilla gunilla;
    private final Krister krister;

    public KristerBrags(Malysh malysh, Gunilla gunilla, Krister krister) {
        this.malysh = malysh;
        this.gunilla = gunilla;
        this.krister = krister;
    }

    @Override
    public void run() {
        Opinion.addOpinion(malysh, new Opinion(Confidence.DEFINITELY, Rate.GOOD, gunilla, EventType.BEFRIEND));

        krister.brag("собакой Еффой", malysh);
    }

    @Override
    public String getState() {
        return "Кристер только и делает, что хвалится своей собакой Еффой, и Малыш ему давно завидует.";
    }
}
