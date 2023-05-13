package com.wvsu.bhms.room;

import com.wvsu.bhms.BhmsApplicationTests;
import com.wvsu.bhms.tenant.Tenant;
import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class RoomResourceIntegrationTest extends BhmsApplicationTests {

    @Autowired
    private RestTemplate restTemplate;
    @LocalServerPort
    private int port;

    @Test
    public void create() {
        Room room = buildRoom();
        String url = "http://localhost:" + port + "/room/create";
        Room saved = restTemplate.postForObject(url, room, Room.class);
        System.out.println(saved);
    }

    @Test
    public void update() {
        Room room = buildRoom();
        room.setId(2);
        String url = "http://localhost:" + port + "/room/update";
        Room saved = restTemplate.postForObject(url, room, Room.class);
        System.out.println(saved);
    }

    @Test
    public void delete() {
        String url = "http://localhost:" + port + "/room/delete?id=1";
        restTemplate.postForObject(url, null, Void.class);
    }

    @Test
    public void findAll() {
        String url = "http://localhost:" + port + "/room/findAll";
        List<Room> rooms = restTemplate.getForObject(url, List.class);
        System.out.println(rooms);
    }

    @Test
    public void findById() {
        String url = "http://localhost:" + port + "/room/findById?id=2";
        Room room = restTemplate.getForObject(url, Room.class);
        System.out.println(room);
    }

    private static Room buildRoom() {
        Room room = new Room();
        room.setName(RandomString.make());
        room.setMonthlyRent(7000);
        room.setDescription(RandomString.make());
        return room;
    }
}
