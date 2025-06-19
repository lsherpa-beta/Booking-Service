package com.sherpa.bookingService.service;

import com.sherpa.bookingService.model.Booking;
import com.sherpa.bookingService.repository.BookingRepository;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Booking saveBooking(Booking booking) {
        boolean exists = bookingRepository.existsByAppointmentDateAndAppointmentTime(
                booking.getAppointmentDate(), booking.getAppointmentTime());

        if (exists) {
            throw new IllegalStateException("This time slot is already booked.");
        }

        return bookingRepository.save(booking);
    }

}
