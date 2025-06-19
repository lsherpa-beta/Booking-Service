package com.sherpa.bookingService.repository;

import com.sherpa.bookingService.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    boolean existsByAppointmentDateAndAppointmentTime(LocalDate date, LocalTime time);

}
