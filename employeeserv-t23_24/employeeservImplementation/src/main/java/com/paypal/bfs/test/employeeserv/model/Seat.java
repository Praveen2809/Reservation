package com.paypal.bfs.test.employeeserv.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "seat")
@FieldDefaults(level = AccessLevel.PRIVATE)
@EntityListeners(AuditingEntityListener.class)
@Data
public class Seat {
    @Id
    @SequenceGenerator(name = "sequenceGenerator",sequenceName = "HIBERNATE_SEQUENCE",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sequenceGenerator")
    Long id;

    private Integer trainNo;

    private String seatNo;

    private String coachNo;

    private Date date1;

    // i will add enum late
    private String seatType;

    // i will add enum late
    private String coachType;

    private boolean available;

    private String ticketNo;

    String startLocation;

    String endLoaction;

    // for booking which are happening for in middle create another entries in this table on run time
}
