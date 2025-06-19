package com.sherpa.bookingService.controller;

import com.sherpa.bookingService.model.Booking;
import com.sherpa.bookingService.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200") // this need to be read from the properties file
@RequestMapping("/api/booking")
public class BookingController {

    private BookingService bookingService;

    @GetMapping("/ping")
    public String healthCheck() {
        return "Welcome to our Nail Therapy";
    }

    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        try {
            Booking saveBooking = bookingService.saveBooking(booking);
            return ResponseEntity.status(HttpStatus.CREATED).body(saveBooking);

        } catch (Exception e) {
            System.out.println("ERROR because of :" + e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
}
