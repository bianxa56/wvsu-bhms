package com.wvsu.bhms.tenant;

import com.wvsu.bhms.room.Room;
import com.wvsu.bhms.room.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TenantServiceImpl implements TenantService {

    @Autowired
    private TenantRepository tenantRepository;

    @Autowired
    private RoomService roomService;

    @Override
    public Tenant create(Tenant tenant) {
        Tenant existing = findTenantByFirstNameAndLastName(tenant);
        if (existing != null) {
            throw new IllegalStateException("Tenant already exists.");
        }
        return tenantRepository.save(tenant);
    }

    @Override
    public Tenant update(Tenant tenant) {
        Tenant existingById = checkTenantIdIfExisting(tenant);
        Tenant existingByFirstNameAndLastName = findTenantByFirstNameAndLastName(tenant);
        Tenant existing = checkTenantNameIfAlreadyExisting(existingById, existingByFirstNameAndLastName);
        if (existing != null) {
            return existing;
        }
        existingById.setFirstName(tenant.getFirstName());
        existingById.setLastName(tenant.getLastName());
        return tenantRepository.save(tenant);
    }

    @Override
    public void delete(long id) {
        tenantRepository.deleteById(id);
    }

    @Override
    public Tenant findById(long id) {
        Optional<Tenant> found = tenantRepository.findById(id);
        return found.orElse(null);
    }

    @Override
    public List<Tenant> findAll() {
        return tenantRepository.findAll();
    }

    @Override
    public Tenant assignRoom(long tenantId, long roomId) {
        Tenant tenant = findTenant(tenantId);
        Room room = findRoom(roomId);
        checkIfRoomIsAlreadyAssigned(roomId);
        tenant.setRoom(room);
        return tenantRepository.save(tenant);
    }

    private void checkIfRoomIsAlreadyAssigned(long roomId) {
        Tenant tenantWithRoom = tenantRepository.findByRoomId(roomId);
        if (tenantWithRoom != null) {
            throw new IllegalStateException("Room is already occupied.");
        }
    }

    private Room findRoom(long roomId) {
        Room room = roomService.findById(roomId);
        if (room == null) {
            throw new IllegalStateException("Room not found.");
        }
        return room;
    }

    private Tenant findTenant(long tenantId) {
        Tenant tenant = findById(tenantId);
        if (tenant == null) {
            throw new IllegalStateException("Tenant not found.");
        }
        return tenant;
    }

    private static Tenant checkTenantNameIfAlreadyExisting(Tenant existingById, Tenant existingByFirstNameAndLastName) {
        if (existingByFirstNameAndLastName != null) {
            if (existingById.getId() != existingByFirstNameAndLastName.getId()) {
                throw new IllegalStateException("Tenant name already exist.");
            }
            return existingById;
        }
        return null;
    }

    private Tenant findTenantByFirstNameAndLastName(Tenant tenant) {
        return tenantRepository.findFirstByFirstNameAndLastName(
                tenant.getFirstName(), tenant.getLastName());
    }

    private Tenant checkTenantIdIfExisting(Tenant tenant) {
        Optional<Tenant> existingById = tenantRepository.findById(tenant.getId());
        if (existingById.isEmpty()) {
            throw new IllegalStateException("Tenant ID does not exist");
        }
        return existingById.get();
    }
}
