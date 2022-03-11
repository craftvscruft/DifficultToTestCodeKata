package org.gamenet.kata.untestable;

import org.gamenet.kata.unmodifiable.objectFilter.ObjectQuery;
import org.gamenet.kata.unmodifiable.display.Displayable;
import org.gamenet.kata.unmodifiable.rooms.BasicRoom;
import org.gamenet.kata.unmodifiable.rooms.ColoredRoom;

import java.util.Iterator;
import java.util.List;

public class RoomDisplayer {
    public RoomDisplayer(IRoomService roomService) {
        this.roomService = roomService;
    }

    private final IRoomService roomService;

    public void createAndDisplayRooms() {
        for (int index = 0; index < 40; index++) {
            roomService.createRandomRoom();
        }

        System.out.println("initial rooms");

        List<BasicRoom> roomList = roomService.getRoomList();
        for (BasicRoom room : roomList) {
            roomService.displayRoom(room);
        }

        ObjectQuery<BasicRoom> roomQuery = new ObjectQuery<>(BasicRoom.class);
        roomQuery.add("width", Integer.valueOf(5));
        List<BasicRoom> filteredRoomList = null;
        try {
            filteredRoomList = roomService.getFilteredRoomList(roomQuery);
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
            roomService.displayRoom(room);
        }
    }

    public static void main(String[] args) {
        RoomDisplayer roomDisplayer = new RoomDisplayer(new RoomService());
        roomDisplayer.createAndDisplayRooms();
    }
}
