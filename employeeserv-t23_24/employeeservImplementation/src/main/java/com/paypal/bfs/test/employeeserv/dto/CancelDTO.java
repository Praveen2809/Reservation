package com.paypal.bfs.test.employeeserv.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({"ticketNo", "customerDtoList"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CancelDTO {
    @JsonProperty("ticketNo")
    public String ticketNo;
    @JsonProperty("customerDtoList")
    public List<CustomerDto> customerDtoList;

    @Data
    @JsonPropertyOrder({"name", "age"})
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CustomerDto{
        @JsonProperty("name")
        private String name;
        @JsonProperty("age")
        private int age;
    }
}
