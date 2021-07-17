package com.paypal.bfs.test.employeeserv.service.impl;

import com.paypal.bfs.test.employeeserv.dto.BookingDTO;
import com.paypal.bfs.test.employeeserv.model.Seat;
import com.paypal.bfs.test.employeeserv.repository.SeatRepository;
import com.paypal.bfs.test.employeeserv.service.BookReservationService;
import com.paypal.bfs.test.employeeserv.service.ReservationRepositoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class BookReservationServiceImpl implements BookReservationService {

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private ReservationRepositoryServiceImpl reservationRepositoryService;

    @Override
    @Transactional
    public String book(BookingDTO bookingDTO) throws Exception {
        validate(bookingDTO);
        String ticketNo = String.valueOf(Math.random());
        for(BookingDTO.CustomerDto customerDto: bookingDTO.getCustomerList()){
            bookTicket(bookingDTO, customerDto, ticketNo);
        }
        return ticketNo;
    }

    private void validate(BookingDTO bookingDTO){

    }

    private void bookTicket(BookingDTO bookingDTO, BookingDTO.CustomerDto customerDto, String ticketNo) throws Exception {
        Seat seat = null;
        if(customerDto.getBirthType() != null){
            seat = seatRepository.findByTrainNoAndCoachTypeAndSeatTypeAndAvailable(bookingDTO.getTrainNo(), bookingDTO.getCoachType(), customerDto.getBirthType()
                    , true).stream().findFirst().orElse(null);
        }else{
            seat = seatRepository.findByTrainNoAndCoachTypeAndAvailable(bookingDTO.getTrainNo(), bookingDTO.getCoachType()
                    , true).stream().findFirst().orElse(null);
        }
        if(seat == null){
            throw new Exception("no seats available");
        }
        // make entry in the table
        seat.setAvailable(false);
        seat.setTicketNo(ticketNo);
        seatRepository.save(seat);
        reservationRepositoryService.addReservation(customerDto.getAge(), customerDto.getName(), ticketNo, seat.getSeatNo());

        // if it not a full journey make entries in this table with available flag
    }
}
