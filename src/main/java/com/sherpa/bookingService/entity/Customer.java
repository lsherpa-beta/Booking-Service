package com.sherpa.bookingService.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customerId;
    private String firstName;
    private String middleName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private double phNumber;

    @OneToMany(mappedBy = "customers", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Booking> bookings;
}
