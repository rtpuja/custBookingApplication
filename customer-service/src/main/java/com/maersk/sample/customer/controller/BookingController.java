package com.maersk.sample.customer.controller;

import com.maersk.sample.customer.model.BookingAvailableResponse;
import com.maersk.sample.customer.model.BookingResponse;
import com.maersk.sample.customer.model.Bookings;
import com.maersk.sample.customer.service.BookingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;

/**
 * @author Pooja Kumawat
 * 01/05/2022 9:58 PM
 */
@Slf4j
@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Value("${server.port}")
    private int port;
  
    @Autowired
    BookingService bookingService;
    
    
    @PostMapping("/")
	public ResponseEntity<BookingResponse> save(@Valid @RequestBody Bookings booking) {
    	BookingResponse response = bookingService.create(booking);
		return new ResponseEntity<BookingResponse>(response, HttpStatus.CREATED);
	}
    
    @PostMapping("/available")
	public ResponseEntity<BookingAvailableResponse> checkAvailable() {
    	BookingAvailableResponse response = bookingService.checkAvailable();
		return new ResponseEntity<BookingAvailableResponse>(response, HttpStatus.CREATED);
	}
    
    @GetMapping("/")
	public ResponseEntity<List<Bookings>> getAll() {
		return new ResponseEntity<List<Bookings>>(bookingService.fetchAll(), HttpStatus.OK);
	}
}
