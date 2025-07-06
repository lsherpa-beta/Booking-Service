package com.sherpa.bookingService.service;

import com.sherpa.bookingService.model.Booking;
import com.sherpa.bookingService.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    BookingRepository bookingRepository;

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

    public List<Booking> findAllBooking() {
        return bookingRepository.findAll();
    }

    public Optional<Booking> findByBookingNbr(Long bookingId) {
        return  bookingRepository.findById(bookingId);
    }
}
