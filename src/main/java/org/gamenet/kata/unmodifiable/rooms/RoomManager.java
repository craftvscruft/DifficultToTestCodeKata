package org.gamenet.kata.unmodifiable.rooms;

import org.gamenet.kata.unmodifiable.display.Displayable;
import org.gamenet.kata.unmodifiable.objectFilter.ObjectQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RoomManager {
    public static Random random = new Random();
    public static List<BasicRoom> roomList = new ArrayList<>();

    public static void createRandomRoom() {
        Displayable.Color[] values = Displayable.Color.values();
        Displayable.Color color = values[random.nextInt(values.length)];
        Integer width = Integer.valueOf(random.nextInt(10));
        Integer height = Integer.valueOf(random.nextInt(10));
        roomList.add(new ColoredRoom(color, width, height));
    }

    public static List<BasicRoom> getFilteredRoomList(ObjectQuery<BasicRoom> query) throws NoSuchFieldException, IllegalAccessException {
        return query.getObjects(roomList);
    }

    public static List<BasicRoom> getRoomList() {
        return roomList;
    }
}
