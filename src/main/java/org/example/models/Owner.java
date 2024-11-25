package org.example.models;

import lombok.Getter;
import lombok.Setter;
import org.example.enums.UserType;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Owner extends User{
    List<Turf> ownedTurfs;
    List<TurfSlotBooking> turfSlotBookings;
    public Owner(String name) {
        super(name, UserType.OWNER);
        this.ownedTurfs = new ArrayList<>();
        this.turfSlotBookings = new ArrayList<>();
    }
}
