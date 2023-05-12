package com.wvsu.bhms.room;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Room {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private double monthlyRent;
    private String description;
}
