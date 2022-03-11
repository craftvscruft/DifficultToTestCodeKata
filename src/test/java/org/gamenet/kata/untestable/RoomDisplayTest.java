package org.gamenet.kata.untestable;

import org.gamenet.kata.unmodifiable.objectFilter.ObjectQuery;
import org.gamenet.kata.unmodifiable.rooms.BasicRoom;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class RoomDisplayTest {
    @Test
    public void createInitialRoomsCreates40Rooms() {
        FakeRoomService roomService = new FakeRoomService();
        RoomDisplayer subject = new RoomDisplayer(roomService);

        subject.createInitialRooms();

        assertEquals(40, roomService.randomRoomsCreated);
    }

    @Test
    public void buildWidthQueryFiltersForWidth5() throws Exception {
        FakeRoomService roomService = new FakeRoomService();
        RoomDisplayer subject = new RoomDisplayer(roomService);

        ObjectQuery<BasicRoom> query = subject.buildWidthQuery();
        BasicRoom foundRoom = new BasicRoom();
        foundRoom.width = 5;
        BasicRoom otherRoom = new BasicRoom();
        otherRoom.width = 4;
        List<BasicRoom> foundRooms = query.getObjects(Arrays.asList(foundRoom, otherRoom));

        assertEquals(1, foundRooms.size());
        assertSame(foundRoom, foundRooms.get(0));
    }
}
