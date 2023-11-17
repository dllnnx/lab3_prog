package org.example.enums;

public enum Position {
    STAND("стоит"),
    LIE("лежит"),
    SIT("сидит"),
    UP("встал"),
    DOWN("сел");
    private String pos;
    Position(String title) {
        this.pos = title;
    }

    public String getPosition(){ return pos; }
}
