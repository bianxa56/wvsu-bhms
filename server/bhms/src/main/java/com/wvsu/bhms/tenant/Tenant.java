package com.wvsu.bhms.tenant;

import com.wvsu.bhms.room.Room;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Tenant {

    @Id
    @GeneratedValue
    private long id;
    private String firstName;
    private String lastName;
    private String address;
    private String contactNumber;
    @OneToOne
    private Room room;
}
