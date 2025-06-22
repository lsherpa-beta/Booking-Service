package com.sherpa.bookingService.model;

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
    private long id;


    private String firstName;

    private String lastName;

    private Long phoneNbr;

    private String email;

    private LocalDate appointmentDate;
    private LocalTime appointmentTime;


}
