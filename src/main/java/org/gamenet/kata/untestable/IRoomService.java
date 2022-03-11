package org.gamenet.kata.untestable;

import org.gamenet.kata.unmodifiable.display.DisplayUtils;
import org.gamenet.kata.unmodifiable.objectFilter.ObjectQuery;
import org.gamenet.kata.unmodifiable.rooms.BasicRoom;
import org.gamenet.kata.unmodifiable.rooms.RoomManager;
import org.gamenet.kata.unmodifiable.rooms.RoomUtils;

import java.util.List;

public interface IRoomService {
    List<BasicRoom> getFilteredRoomList(ObjectQuery<BasicRoom> roomQuery) throws NoSuchFieldException, IllegalAccessException;

    void displayRoom(BasicRoom room);

    List<BasicRoom> getRoomList();

    void createRandomRoom();
}
