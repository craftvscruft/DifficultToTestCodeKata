package org.gamenet.kata.unmodifiable.rooms;

import org.gamenet.kata.unmodifiable.display.Displayable;

public class ColoredRoom extends BasicRoom {
    private Displayable.Color color;

    ColoredRoom(Displayable.Color color, Integer width, Integer height) {
        super();
        this.color = color;
        this.width = width;
        this.height = height;
    }

    public Displayable.Color getColor() {
        return color;
    }
}
