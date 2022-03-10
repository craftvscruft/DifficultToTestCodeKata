package org.gamenet.kata.unmodifiable.rooms;

import org.gamenet.kata.unmodifiable.display.Displayable;

public class DisplayableColoredRoom implements Displayable {
    private final ColoredRoom room;

    public DisplayableColoredRoom(ColoredRoom room) {
        this.room = room;
    }

    public void display() {
        for (int y = 0; y < room.height; y++) {
            for (int x = 0; x < room.width; x++) {
                switch(room.getColor()) {
                    case RED:
                        System.out.print("R");
                        break;
                    case GREEN:
                        System.out.print("G");
                        break;
                    case BLUE:
                        System.out.print("B");
                        break;
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
