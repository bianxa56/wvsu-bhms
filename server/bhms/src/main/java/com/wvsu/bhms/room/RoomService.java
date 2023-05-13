package com.wvsu.bhms.room;

import java.util.List;

public interface RoomService {
    Room create(Room room);

    Room update(Room room);

    void delete(long id);

    Room findById(long id);

    List<Room> findAll();
}
