package com.paypal.bfs.test.employeeserv.controller;

import com.paypal.bfs.test.employeeserv.dto.BookingDTO;
import com.paypal.bfs.test.employeeserv.dto.CancelDTO;
import com.paypal.bfs.test.employeeserv.service.ReservationService;
import com.paypal.bfs.test.employeeserv.service.impl.InsertData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @Autowired
    private InsertData insertData;

    // book reource
        // book ticket
        // check availability
    // cancel resource
    // ticket entity
        // get, post, put, patch
        // create - post - /
        // get - get - /{id}
        // delete - delete -/{id}
        // update - put/patch - /
        // getAll - get - /

    @PostMapping(path = "/book", produces = "application/json")
    public ResponseEntity bookTicket(@RequestBody BookingDTO bookingDTO) throws Exception {
        reservationService.book(bookingDTO);
        return  ResponseEntity.ok().body("Ticket booked");
    }

    @PostMapping(path = "/cancel", produces = "application/json")
    public ResponseEntity cancelTicket(@RequestBody CancelDTO cancelDTO) throws Exception {
        reservationService.cancel(cancelDTO);
        return  ResponseEntity.ok().body("Cancelled successfully");
    }

    @PostMapping(path = "/insert", produces = "application/json")
    public ResponseEntity cancelTicket() throws Exception {
        insertData.insertData();
        return  ResponseEntity.ok().body("");
    }
}
