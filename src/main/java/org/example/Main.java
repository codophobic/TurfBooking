package org.example;

import org.example.controllers.BookingController;
import org.example.controllers.PlaygroundController;

import org.example.controllers.TurfsController;
import org.example.enums.CancelBookingStatus;
import org.example.models.*;
import org.example.repository.PlaygroundRepository;
import org.example.repository.TurfRepository;
import org.example.repository.UserRepository;
import org.example.service.PlaygroundService;
import org.example.service.TurfService;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Owner owner1 = new Owner("Ankit");
        Owner owner2 = new Owner("Bala");

        TurfRepository turfRepository = new TurfRepository();
        PlaygroundRepository playgroundRepository = new PlaygroundRepository();
        UserRepository userRepository = new UserRepository();
        userRepository.addUser(owner1);
        userRepository.addUser(owner2);

        PlaygroundService playgroundService = new PlaygroundService(playgroundRepository);
        PlaygroundController playgroundController = new PlaygroundController(playgroundService);
        Playground playground = playgroundController.createPlayground();


        TurfService turfService = new TurfService(turfRepository,userRepository,playgroundRepository);
        TurfsController turfController = new TurfsController(turfService);

        Turf turf = turfController.createNewTurf(owner1,playground);
//        turfController.createNewTurf(owner2,playground);

        Customer customer = new Customer("Ashish");
        userRepository.addUser(customer);

        List<TurfSlot> availableSlots = playgroundController.getAllAvailableSlots(playground);

        TurfSlot selectedTurfSlot = availableSlots.get(0);

        BookingController bookingController = new BookingController(userRepository);

        try {
            TurfSlotBooking  booking = bookingController.createBooking(selectedTurfSlot.getTurf(), selectedTurfSlot.getSlot(), customer);
            System.out.println("Hey "+ booking.getCustomer().getName() +" Booking success for turf"+ booking.getTurf().getId() + " slot"+ booking.getSlot().getId() );
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }


        List<TurfSlotBooking> bookings = customer.getBookings();
        List<TurfSlotBooking> ownerBookings = owner1.getTurfSlotBookings();


        //ideally a bookingService had to be created which would be called by bookingController but because of less time managed all methods in controller
        CancelBookingStatus cancelBookingStatus = bookingController.cancelBooking(bookings.get(0).getId(), customer, bookings.get(0).getTurf().getOwner());

        if(!cancelBookingStatus.equals(CancelBookingStatus.CANCELLED)) {
            System.out.println("Invalid booking trying to cancel");
        }


    }
}