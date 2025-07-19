package com.sherpa.bookingService.entity;

import jakarta.persistence.*;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@Table(name="booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long BookingId;

    private LocalDate appointmentDate;
    private LocalTime appointmentTime;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customers;

}

