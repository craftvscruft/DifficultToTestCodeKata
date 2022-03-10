package org.gamenet.kata.unmodifiable.rooms;

import org.gamenet.kata.unmodifiable.display.Displayable;

public class RoomUtils {
    public static Displayable getDisplayable(Object object) {
        if (object instanceof ColoredRoom) {
            return new DisplayableColoredRoom((ColoredRoom)object);
        } else  if (object instanceof BasicRoom) {
            return new DisplayableBasicRoom((BasicRoom)object);
        }
        return null;
    }
}
