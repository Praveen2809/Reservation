package com.paypal.bfs.test.employeeserv.repository;

import com.paypal.bfs.test.employeeserv.model.ReservationDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationDetailsRepository extends JpaRepository<ReservationDetails, Long> {
    List<ReservationDetails> findByTicketNo(String ticketNo);
}
