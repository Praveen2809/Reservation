package com.paypal.bfs.test.employeeserv.service;

import com.paypal.bfs.test.employeeserv.dto.CancelDTO;

public interface CancelreservationService {
    boolean cancel(CancelDTO cancelDTO) throws Exception;
}
