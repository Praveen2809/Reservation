package com.paypal.bfs.test.employeeserv.service.impl;

import com.paypal.bfs.test.employeeserv.dto.CancelDTO;
import com.paypal.bfs.test.employeeserv.model.ReservationDetails;
import com.paypal.bfs.test.employeeserv.model.Seat;
import com.paypal.bfs.test.employeeserv.repository.ReservationDetailsRepository;
import com.paypal.bfs.test.employeeserv.repository.SeatRepository;
import com.paypal.bfs.test.employeeserv.service.CancelreservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CancelReservationServiceImpl implements CancelreservationService {
    @Autowired
    ReservationDetailsRepository reservationDetailsRepository;

    @Autowired
    SeatRepository seatRepository;

    @Override
    @Transactional
    public boolean cancel(CancelDTO cancelDTO) throws Exception {
        List<Seat> seats = seatRepository.findByTicketNo(cancelDTO.getTicketNo());
        List<ReservationDetails> reservationDetailsList = reservationDetailsRepository.findByTicketNo(cancelDTO.getTicketNo());
        for(CancelDTO.CustomerDto customerDto : cancelDTO.getCustomerDtoList()){
            ReservationDetails reservationDetails = findReservation(customerDto.getName(), customerDto.getAge(), reservationDetailsList);
            Seat seat = findSeat(reservationDetails.getSeatNo(), seats);
            seat.setTicketNo(null);
            seat.setAvailable(true);
            reservationDetails.setActive(false);
            seatRepository.save(seat);
            reservationDetailsRepository.save(reservationDetails);
        }
        return true;
    }

    private ReservationDetails findReservation(String name, int age, List<ReservationDetails> reservationDetailList) throws Exception {
        for(ReservationDetails reservationDetails: reservationDetailList){
            if(reservationDetails.getAge() == age && reservationDetails.getName().equalsIgnoreCase(name)){
                if(!reservationDetails.isActive()){
                    throw new Exception("ticket already cancelled for " + reservationDetails.getSeatNo());
                }
            }
                return reservationDetails;
        }
        throw new Exception("Invalid Reservation for " + name);
    }

    private Seat findSeat(String seatNo, List<Seat> seats){
        for(Seat seat: seats){
            if(seat.getSeatNo().equals(seatNo))
                return seat;
        }
        return null;
    }
}
