package com.maersk.sample.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maersk.sample.customer.model.Bookings;

/**
 * @author Pooja Kumawat
 * 01/05/2022 11:30 PM
 */
public interface BookingRepository extends JpaRepository<Bookings, Long>{

}
