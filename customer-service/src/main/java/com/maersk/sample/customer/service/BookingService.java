package com.maersk.sample.customer.service;

import java.util.List;

import com.maersk.sample.customer.model.BookingAvailableResponse;
import com.maersk.sample.customer.model.BookingResponse;
import com.maersk.sample.customer.model.Bookings;


/**
 * @author Pooja Kumawat
 * 01/05/2022 11:58 PM
 */
public interface BookingService {
    /**
     * This method is used to save customer bookings details
     * @param user
     * @return String
     */
	public BookingResponse create(Bookings user);

	 /**
     * This method is used to get customer bookings details
     * @param 
     * @return List<Bookings>
     */
	public List<Bookings> fetchAll();

	 /**
     * This method is used to check available space of Bookings
     * @param 
     * @return BookingAvailableResponse
     */
	public BookingAvailableResponse checkAvailable();

}
