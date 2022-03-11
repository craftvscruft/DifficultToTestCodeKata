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
        createInitialRooms();

        System.out.println("initial rooms");

        displayRooms(roomService.getRoomList());

        ObjectQuery<BasicRoom> roomQuery = buildWidthQuery();
        List<BasicRoom> filteredRoomList = getFilteredRoomListFailingSilently(roomQuery);

        removeBlueRooms(filteredRoomList);

        System.out.println("filtered rooms");

        displayRooms(filteredRoomList);
    }

    void removeBlueRooms(List<BasicRoom> rooms) {
        for (Iterator<BasicRoom> it = rooms.iterator(); it.hasNext(); ) {
            BasicRoom basicRoom = it.next();
            ColoredRoom coloredRoom = (ColoredRoom)basicRoom;
            if (Displayable.Color.BLUE == coloredRoom.getColor()) {
                it.remove();
            }
        }
    }

    List<BasicRoom> getFilteredRoomListFailingSilently(ObjectQuery<BasicRoom> roomQuery) {
        try {
            return roomService.getFilteredRoomList(roomQuery);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            // We should never reach here
        }
        return null;
    }

    ObjectQuery<BasicRoom> buildWidthQuery() {
        ObjectQuery<BasicRoom> roomQuery = new ObjectQuery<>(BasicRoom.class);
        roomQuery.add("width", Integer.valueOf(5));
        return roomQuery;
    }

    void displayRooms(List<BasicRoom> rooms) {
        for (BasicRoom room : rooms) {
            roomService.displayRoom(room);
        }
    }

    void createInitialRooms() {
        for (int index = 0; index < 40; index++) {
            roomService.createRandomRoom();
        }
    }

    public static void main(String[] args) {
        RoomDisplayer roomDisplayer = new RoomDisplayer(new RoomService());
        roomDisplayer.createAndDisplayRooms();
    }
}
