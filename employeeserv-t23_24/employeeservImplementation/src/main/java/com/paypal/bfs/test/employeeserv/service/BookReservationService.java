package com.paypal.bfs.test.employeeserv.service;

import com.paypal.bfs.test.employeeserv.dto.BookingDTO;

public interface BookReservationService {
    String book(BookingDTO bookingDTO) throws Exception;
}
