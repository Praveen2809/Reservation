package com.paypal.bfs.test.employeeserv.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "reservation_details")
@FieldDefaults(level = AccessLevel.PRIVATE)
@EntityListeners(AuditingEntityListener.class)
@Data
public class ReservationDetails {

    @Id
    @SequenceGenerator(name = "sequenceGenerator",sequenceName = "HIBERNATE_SEQUENCE",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sequenceGenerator")
    Long id;

    private String ticketNo;

    private String seatNo;

    private boolean primaryCustomer;

    private String name;

    private int age;

    private boolean active;
}
