package com.paypal.bfs.test.employeeserv.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "customer")
@FieldDefaults(level = AccessLevel.PRIVATE)
@EntityListeners(AuditingEntityListener.class)
@Data
public class Customer {
    @Id
    @SequenceGenerator(name = "sequenceGenerator",sequenceName = "HIBERNATE_SEQUENCE",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sequenceGenerator")
    Long id;

    private String name;
    private String mobileNo;

    private int age;
}
