package com.paypal.bfs.test.employeeserv.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "train")
@FieldDefaults(level = AccessLevel.PRIVATE)
@EntityListeners(AuditingEntityListener.class)
@Data
public class Train {
    // all attributes
    @Id
    private Integer TrainNo;

    private String startLocation;

    private String endLocation;
}
