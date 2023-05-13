package com.wvsu.bhms.room;

import com.wvsu.bhms.tenant.Tenant;
import com.wvsu.bhms.tenant.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomResource {

    @Autowired
    private RoomService roomService;

    @PostMapping("/create")
    Room create(@RequestBody Room room) {
        return roomService.create(room);
    }

    @PostMapping("/update")
    Room update(@RequestBody Room room) {
        return roomService.update(room);
    }

    @PostMapping("/delete")
    void delete(@RequestParam long id) {
        roomService.delete(id);
    }

    @GetMapping("/findAll")
    List<Room> findAll() {
        return roomService.findAll();
    }

    @GetMapping("/findById")
    Room findById(@RequestParam long id) {
        return roomService.findById(id);
    }
}
