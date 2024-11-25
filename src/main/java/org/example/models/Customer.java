package org.example.models;

import lombok.Getter;
import lombok.Setter;
import org.example.enums.UserType;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Customer extends User{
    List<TurfSlotBooking> bookings;
    public Customer(String name) {
        super(name, UserType.CUSTOMER);
        this.bookings = new ArrayList<>();
    }
}
