package org.gamenet.kata.untestable;

import org.gamenet.kata.unmodifiable.display.DisplayUtils;
import org.gamenet.kata.unmodifiable.objectFilter.ObjectQuery;
import org.gamenet.kata.unmodifiable.rooms.BasicRoom;
import org.gamenet.kata.unmodifiable.rooms.RoomManager;
import org.gamenet.kata.unmodifiable.rooms.RoomUtils;

import java.util.List;

public class RoomService {
    public RoomService() {
    }

    public List<BasicRoom> getFilteredRoomList(ObjectQuery<BasicRoom> roomQuery) throws NoSuchFieldException, IllegalAccessException {
        return RoomManager.getFilteredRoomList(roomQuery);
    }

    public void displayRoom(BasicRoom room) {
        DisplayUtils.display(RoomUtils.getDisplayable(room));
    }

    public List<BasicRoom> getRoomList() {
        return RoomManager.getRoomList();
    }

    public void createRandomRoom() {
        RoomManager.createRandomRoom();
    }
}