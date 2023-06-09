package com.wvsu.bhms.room;

import com.wvsu.bhms.BhmsApplicationTests;
import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RoomServiceIntegrationTest extends BhmsApplicationTests {

    @Autowired
    private RoomService roomService;

    @Test
    public void create() {
        Room saved = roomService.create(buildRoom());
        System.out.println(saved);
        assertNotNull(saved);
    }

    @Test
    public void update() {
        Room room = buildRoom();
        room.setId(2);
        Room saved = roomService.update(room);
        System.out.println(saved);
        assertNotNull(saved);
    }

    @Test
    public void findById() {
        Room saved = roomService.create(buildRoom());
        Room found = roomService.findById(saved.getId());
        assertNotNull(found);
    }

    @Test
    public void delete() {
        Room saved = roomService.create(buildRoom());
        roomService.delete(saved.getId());
        Room found = roomService.findById(saved.getId());
        assertNull(found);
    }
    @Test
    public void findAll() {
        Room saved = roomService.create(buildRoom());
        List<Room> rooms =  roomService.findAll();
        assertTrue(rooms.size() > 0);
    }

    private Room buildRoom() {
        Room room = new Room();
        room.setName(RandomString.make());
        room.setMonthlyRent(10000);
        room.setRoomLocation(RandomString.make());
        room.setCapacity(RandomString.make());
        room.setDescription(RandomString.make());
        return room;
    }
}
