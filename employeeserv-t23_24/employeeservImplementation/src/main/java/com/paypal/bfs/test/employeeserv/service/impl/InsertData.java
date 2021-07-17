package com.paypal.bfs.test.employeeserv.service.impl;

import com.paypal.bfs.test.employeeserv.model.Seat;
import com.paypal.bfs.test.employeeserv.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class InsertData {

    @Autowired
    private SeatRepository seatRepository;

   public void insertData(){
       addSeat(123, "1");
       addSeat(123, "2");
       addSeat(123, "3");
   }

   private void addSeat(int trainNo, String seatNo){
       Seat seat = new Seat();
       seat.setAvailable(true);
       seat.setSeatType("L");
       seat.setCoachNo("1");
       seat.setDate1(new Date());
       seat.setCoachType("A");
       seat.setStartLocation("A");
       seat.setEndLoaction("Z");
       seat.setTrainNo(trainNo);
       seat.setSeatNo(seatNo);
       seatRepository.save(seat);
   }
}
