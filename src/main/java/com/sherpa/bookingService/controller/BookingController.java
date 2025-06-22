package com.sherpa.bookingService.controller;

import com.sherpa.bookingService.model.Booking;
import com.sherpa.bookingService.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200") // this need to be read from the properties file
@RequestMapping("/api/booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping("/ping")
    public String healthCheck() {
        return "Welcome to our Nail Therapy";
    }

    @GetMapping
    public List<Booking> getAllBooking() {
        return bookingService.findAllBooking();
    }

    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {

        Booking saved = bookingService.saveBooking(booking);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(saved);  // return the saved booking
    }
}
