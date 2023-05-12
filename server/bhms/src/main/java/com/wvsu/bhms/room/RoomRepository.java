package com.wvsu.bhms.room;

import com.wvsu.bhms.tenant.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room,Long> {
    Room findByName(String name);
}
