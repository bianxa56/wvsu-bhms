package com.wvsu.bhms.room;

import com.wvsu.bhms.tenant.Tenant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;
    @Override
    public Room create(Room room) {
        Room existing = findRoomByName(room);
        if (existing != null) {
            throw new IllegalStateException("Room already exist.");
        }
        return roomRepository.save(room);
    }

    @Override
    public Room update(Room room) {
        Room existingById = checkRoomIdIfExisting(room);
        Room existingByName = findByName(room);
        Room existing = checkRoomNameIfAlreadyExisting(existingById, existingByName);
        if (existing != null) {
            return existing;
        }
        existingById.setName(room.getName());
        existingById.setMonthlyRent(room.getMonthlyRent());
        existingById.setDescription(room.getDescription());
        return roomRepository.save(room);
    }

    @Override
    public void delete(long id) {
        roomRepository.deleteById(id);
    }

    @Override
    public Room findById(long id) {
        Optional<Room> found = roomRepository.findById(id);
        return found.orElse(null);
    }

    @Override
    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    private Room checkRoomNameIfAlreadyExisting(Room existingById, Room existingByName) {
        if (existingByName != null) {
            if (existingById.getId() != existingByName.getId()) {
                throw new IllegalStateException("Room name already exist.");
            }
            return existingById;
        }
        return null;
    }

    private Room findByName(Room room) {
        return roomRepository.findByName(room.getName());
    }

    private Room checkRoomIdIfExisting(Room room) {
        Optional<Room> existingById = roomRepository.findById(room.getId());
        if (existingById.isEmpty()) {
            throw new IllegalStateException("Room ID does not exist");
        }
        return existingById.get();
    }

    private Room findRoomByName(Room room) {
        return roomRepository.findByName(room.getName());
    }
}
