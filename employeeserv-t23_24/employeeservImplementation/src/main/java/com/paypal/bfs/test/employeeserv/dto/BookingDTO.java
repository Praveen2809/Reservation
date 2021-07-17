package com.paypal.bfs.test.employeeserv.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({"noSeats","trainNo", "coachType", "startLocation", "endLocation", "customerList"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookingDTO {

//    @JsonProperty("date")
//    private Date date;

    @JsonProperty("noSeats")
    private Integer noSeats;

    @JsonProperty("trainNo")
    private Integer trainNo;

    @JsonProperty("coachType")
    private String coachType;

    @JsonProperty("startLocation")
    private String startLocation;

    @JsonProperty("endLocation")
    private String endLocation;

    @JsonProperty("customerList")
    private List<CustomerDto> customerList;

    @Data
    @JsonPropertyOrder({"name", "age", "birthType"})
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CustomerDto{
        @JsonProperty("name")
        private String name;
        @JsonProperty("age")
        private int age;
        @JsonProperty("birthType")
        private String birthType;
    }
}
