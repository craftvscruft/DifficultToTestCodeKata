package org.gamenet.kata.unmodifiable.rooms;

import org.gamenet.kata.unmodifiable.display.Displayable;

public class DisplayableBasicRoom implements Displayable {
    private final BasicRoom room;

    public DisplayableBasicRoom(BasicRoom room) {
        this.room = room;
    }

    public void display() {
        for (int y = 0; y < room.height; y++) {
            for (int x = 0; x < room.width; x++) {
                System.out.print("#");
            }
            System.out.println();
        }
        System.out.println();
    }
}
