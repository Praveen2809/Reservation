package com.paypal.bfs.test.employeeserv.service;

import com.paypal.bfs.test.employeeserv.dto.BookingDTO;
import com.paypal.bfs.test.employeeserv.dto.CancelDTO;

public interface ReservationService {
    String book(BookingDTO bookingDTO) throws Exception;
    boolean cancel(CancelDTO cancelDTO) throws Exception;
}
