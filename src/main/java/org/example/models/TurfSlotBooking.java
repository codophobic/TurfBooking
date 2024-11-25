package org.example.models;

import lombok.Getter;
import lombok.Setter;
import org.example.enums.SlotStatus;

@Setter
@Getter
public class TurfSlotBooking extends BaseEntity{
    private Turf turf;
    private Slot slot;
    private Customer customer;

    private static int cnt = 0;
    public TurfSlotBooking(Turf turf, Slot slot, Customer customer) {
        super(cnt++);
        this.turf = turf;
        this.slot = slot;
        slot.setSlotStatus(SlotStatus.BOOKED);
        this.customer = customer;
    }
}
