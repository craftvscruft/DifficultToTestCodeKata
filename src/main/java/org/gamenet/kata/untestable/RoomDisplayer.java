package org.gamenet.kata.untestable;

import org.gamenet.kata.unmodifiable.display.DisplayUtils;
import org.gamenet.kata.unmodifiable.objectFilter.ObjectQuery;
import org.gamenet.kata.unmodifiable.display.Displayable;
import org.gamenet.kata.unmodifiable.rooms.BasicRoom;
import org.gamenet.kata.unmodifiable.rooms.ColoredRoom;
import org.gamenet.kata.unmodifiable.rooms.RoomManager;
import org.gamenet.kata.unmodifiable.rooms.RoomUtils;

import java.util.Iterator;
import java.util.List;

public class RoomDisplayer {
    public void createAndDisplayRooms() {
        for (int index = 0; index < 40; index++) {
            RoomManager.createRandomRoom();
        }

        System.out.println("initial rooms");

        List<BasicRoom> roomList = RoomManager.getRoomList();
        for (BasicRoom room : roomList) {
            DisplayUtils.display(RoomUtils.getDisplayable(room));
        }

        ObjectQuery<BasicRoom> roomQuery = new ObjectQuery<>(BasicRoom.class);
        roomQuery.add("width", Integer.valueOf(5));
        List<BasicRoom> filteredRoomList = null;
        try {
            filteredRoomList = RoomManager.getFilteredRoomList(roomQuery);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            // We should never reach here
        }

        for (Iterator<BasicRoom> it = filteredRoomList.iterator(); it.hasNext(); ) {
            BasicRoom basicRoom = it.next();
            ColoredRoom coloredRoom = (ColoredRoom)basicRoom;
            if (Displayable.Color.BLUE == coloredRoom.getColor()) {
                it.remove();
            }
        }

        System.out.println("filtered rooms");

        for (BasicRoom room : filteredRoomList) {
            DisplayUtils.display(RoomUtils.getDisplayable(room));
        }
    }

    public static void main(String[] args) {
        RoomDisplayer roomDisplayer = new RoomDisplayer();
        roomDisplayer.createAndDisplayRooms();
    }
}
