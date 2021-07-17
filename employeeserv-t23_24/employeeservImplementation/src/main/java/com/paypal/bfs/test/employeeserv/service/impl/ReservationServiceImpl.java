package com.paypal.bfs.test.employeeserv.service.impl;

import com.paypal.bfs.test.employeeserv.dto.BookingDTO;
import com.paypal.bfs.test.employeeserv.dto.CancelDTO;
import com.paypal.bfs.test.employeeserv.service.BookReservationService;
import com.paypal.bfs.test.employeeserv.service.CancelreservationService;
import com.paypal.bfs.test.employeeserv.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("reservationService")
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    BookReservationService bookReservationService;

    @Autowired
    CancelreservationService cancelreservationService;

    @Override
    public String book(BookingDTO bookingDTO) throws Exception {
        return bookReservationService.book(bookingDTO);
    }

    @Override
    public boolean cancel(CancelDTO cancelDTO) throws Exception {
        return cancelreservationService.cancel(cancelDTO);
    }
}
