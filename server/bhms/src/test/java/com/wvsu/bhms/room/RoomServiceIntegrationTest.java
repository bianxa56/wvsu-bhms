package com.wvsu.bhms.room;

import com.wvsu.bhms.BhmsApplicationTests;
import com.wvsu.bhms.tenant.Tenant;
import com.wvsu.bhms.tenant.TenantService;
import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

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
        room.setId(1);
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

    private Room buildRoom() {
        Room room = new Room();
        room.setName(RandomString.make());
        room.setMonthlyRent(10000);
        room.setDescription(RandomString.make());
        return room;
    }
}
