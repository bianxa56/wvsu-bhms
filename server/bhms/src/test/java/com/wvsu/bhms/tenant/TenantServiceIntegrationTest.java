package com.wvsu.bhms.tenant;

import com.wvsu.bhms.BhmsApplicationTests;
import com.wvsu.bhms.room.Room;
import com.wvsu.bhms.room.RoomService;
import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TenantServiceIntegrationTest extends BhmsApplicationTests {

    @Autowired
    private TenantService tenantService;

    @Autowired
    private RoomService roomService;

    @Test
    public void create() {
        Tenant saved = tenantService.create(buildTenant());
        System.out.println(saved);
        assertNotNull(saved);
    }

    @Test
    public void createExisting() {
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            Tenant tenant = new Tenant();
            tenant.setFirstName("Java");
            tenant.setLastName("Woki");
            tenant.setAddress("Cabatuan");
            tenant.setContactNumber("091234");
            tenantService.create(tenant);
        });
        assertEquals("Tenant already exists.", exception.getMessage());
    }

    @Test
    public void update() {
        Tenant tenant = buildTenant();
        tenant.setId(52);
        Tenant saved = tenantService.update(tenant);
        System.out.println(saved);
        assertNotNull(saved);
    }

    @Test
    public void delete() {
        Tenant saved = tenantService.create(buildTenant());
        tenantService.delete(saved.getId());
        Tenant found = tenantService.findById(saved.getId());
        assertNull(found);
    }

    @Test
    public void findAll() {
        Tenant saved = tenantService.create(buildTenant());
        List<Tenant> tenants =  tenantService.findAll();
        assertTrue(tenants.size() > 0);
    }

    @Test
    public void createWithRoom() {
        Tenant tenant = tenantService.create(buildTenant());
        Room room = roomService.create(buildRoom());
        Tenant tenantWithRoom = tenantService.assignRoom(tenant.getId(), room.getId());
        assertNotNull(tenantWithRoom);
    }

    private static Tenant buildTenant() {
        Tenant tenant = new Tenant();
        tenant.setFirstName(RandomString.make());
        tenant.setLastName(RandomString.make());
        tenant.setAddress(RandomString.make());
        tenant.setContactNumber(RandomString.make());
        return tenant;
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
