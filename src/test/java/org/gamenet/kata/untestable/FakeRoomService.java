package org.gamenet.kata.untestable;

import org.gamenet.kata.unmodifiable.objectFilter.ObjectQuery;
import org.gamenet.kata.unmodifiable.rooms.BasicRoom;

import java.util.List;

public class FakeRoomService implements IRoomService {
    int randomRoomsCreated = 0;

    @Override
    public List<BasicRoom> getFilteredRoomList(ObjectQuery<BasicRoom> roomQuery) throws NoSuchFieldException, IllegalAccessException {
        return null;
    }

    @Override
    public void displayRoom(BasicRoom room) {

    }

    @Override
    public List<BasicRoom> getRoomList() {
        return null;
    }

    @Override
    public void createRandomRoom() {
        randomRoomsCreated++;
    }
}
