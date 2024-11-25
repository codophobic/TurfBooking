package org.example.controllers;

import org.example.enums.CancelBookingStatus;
import org.example.enums.SlotStatus;
import org.example.models.*;
import org.example.repository.UserRepository;

import java.util.List;

public class BookingController {


    private UserRepository userRepository;

    public BookingController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public TurfSlotBooking createBooking(Turf turf, Slot slot, Customer customer) throws Exception {
        //validate ifslot available or else throw exception
        for(Slot slot1: turf.getSlots()){
            if(slot1.getStartTime() == slot.getStartTime() && !slot1.getSlotStatus().equals(SlotStatus.AVAILABLE)){
                throw new Exception("invalid slot");
            }
        }
        TurfSlotBooking turfSlotBooking = new TurfSlotBooking(turf,slot,customer);
        Customer user = (Customer) userRepository.getUser(customer.getId());
        Owner owner = (Owner) userRepository.getUser(turf.getOwner().getId());
        user.getBookings().add(turfSlotBooking);
        owner.getTurfSlotBookings().add(turfSlotBooking);

        return turfSlotBooking;

    }

    public CancelBookingStatus cancelBooking(int turfSlotBookingId, Customer customer, Owner owner) throws Exception {

        for(TurfSlotBooking booking: customer.getBookings()){
            if(booking.getId() == turfSlotBookingId){
                customer.getBookings().remove(booking);
                System.out.println(customer.getName() + ", your booking with this id"+ booking.getId()+ " has been cancelled");
                owner.getTurfSlotBookings().remove(booking);
                return CancelBookingStatus.CANCELLED;
            }
        }
        return CancelBookingStatus.ERROR_IN_CANCEL;
    }

    public List<TurfSlotBooking> getBookings(User user){
        Customer customer = (Customer) userRepository.getUser(user.getId());
        return customer.getBookings();

    }
}
