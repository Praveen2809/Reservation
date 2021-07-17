package com.paypal.bfs.test.employeeserv.repository;

import com.paypal.bfs.test.employeeserv.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findByTrainNoAndCoachTypeAndSeatTypeAndAvailable(Integer trainNo, String coachType, String seatType, boolean available);
    List<Seat> findByTrainNoAndCoachTypeAndAvailable(Integer trainNo, String coachType, boolean available);
    List<Seat> findByTicketNo(String ticketNo);
}
