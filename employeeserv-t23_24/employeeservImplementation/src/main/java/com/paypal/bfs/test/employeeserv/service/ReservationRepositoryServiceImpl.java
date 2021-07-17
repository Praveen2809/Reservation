package com.paypal.bfs.test.employeeserv.service;

import com.paypal.bfs.test.employeeserv.model.ReservationDetails;
import com.paypal.bfs.test.employeeserv.repository.ReservationDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationRepositoryServiceImpl {
    @Autowired
    private ReservationDetailsRepository reservationDetailsRepository;

    public void addReservation(int age, String name, String ticketNo, String seatNo){
        ReservationDetails reservationDetails = new ReservationDetails();
        reservationDetails.setAge(age);
        reservationDetails.setName(name);
        reservationDetails.setPrimaryCustomer(false);
        reservationDetails.setTicketNo(ticketNo);
        reservationDetails.setActive(true);
        reservationDetails.setSeatNo(seatNo);
        reservationDetailsRepository.save(reservationDetails);
    }
}
