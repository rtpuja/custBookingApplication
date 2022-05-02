package com.maersk.sample.customer.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.maersk.sample.customer.repository.BookingRepository;
import com.maersk.sample.customer.service.BookingService;
import com.maersk.sample.customer.constants.CustomerConstants;
import com.maersk.sample.customer.exception.BookingException;
import com.maersk.sample.customer.model.BookingAvailableCount;
import com.maersk.sample.customer.model.BookingAvailableResponse;
import com.maersk.sample.customer.model.BookingResponse;
import com.maersk.sample.customer.model.Bookings;

/**
 * @author Pooja Kumawat 01/05/2022 11:58 PM
 */
@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	RestTemplate restTemplate;

	Logger logger = LoggerFactory.getLogger(BookingServiceImpl.class);

	@Override
	public BookingResponse create(Bookings booking) {
		try {
			Optional<Bookings> opt = Optional.ofNullable(bookingRepository.save(booking));
			if (opt.isPresent()) {
				BookingResponse bookingResponse = new BookingResponse();
				bookingResponse.setBookingRef(opt.get().getId());
				return bookingResponse;
			} else {
				throw new Exception();
			}
		} catch (Exception ex) {
			logger.error(CustomerConstants.ERROR_MSG);
			throw new BookingException(CustomerConstants.ERROR_MSG);
		}
	}

	@Override
	public List<Bookings> fetchAll() {
		try {
			Optional<List<Bookings>> opt = Optional.ofNullable(bookingRepository.findAll());
			if (opt.isPresent()) {
				return opt.get();
			} else {
				throw new Exception();
			}
		} catch (Exception ex) {
			logger.error(CustomerConstants.ERROR_GETTING_DATA_MSG);
			throw new BookingException(CustomerConstants.ERROR_GETTING_DATA_MSG);
		}
	}

	@Override
	public BookingAvailableResponse checkAvailable() {
		HttpHeaders headers = new HttpHeaders();
		boolean val = false;
		BookingAvailableResponse res = new BookingAvailableResponse();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		try {
			/*calling external srvce using resttemplate */
//			BookingAvailableCount count = restTemplate
//					.exchange("https://www.maersk.com/api/bookings/checkAvailable", HttpMethod.GET, entity, BookingAvailableCount.class)
//					.getBody();
//			val = count.getAvailableSpace() > 0 ? true : false;
			Random rand = new Random();
			int randomNum = rand.nextInt(10) + 1;
			val = randomNum > 0 ? true : false;
			res.setAvailable(val);
			return res;
		} catch (Exception ex) {
			logger.error(CustomerConstants.ERROR_GETTING_DATA_MSG);
			throw new BookingException(CustomerConstants.ERROR_GETTING_DATA_MSG);
		}	
	}

}
