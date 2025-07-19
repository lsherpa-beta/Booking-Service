package com.sherpa.bookingService.repository;

import com.sherpa.bookingService.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
