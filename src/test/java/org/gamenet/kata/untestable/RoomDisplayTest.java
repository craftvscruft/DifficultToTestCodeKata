package org.gamenet.kata.untestable;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class RoomDisplayTest {
    @Test
    public void createInitialRoomsCreates40Rooms() {
        FakeRoomService roomService = new FakeRoomService();
        RoomDisplayer subject = new RoomDisplayer(roomService);

        subject.createInitialRooms();

        assertEquals(40, roomService.randomRoomsCreated);
    }
}
