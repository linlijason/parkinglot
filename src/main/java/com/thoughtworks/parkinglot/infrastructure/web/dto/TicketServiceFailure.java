package com.thoughtworks.parkinglot.infrastructure.web.dto;

import com.thoughtworks.parkinglot.domain.entity.Ticket;
import com.thoughtworks.parkinglot.infrastructure.web.TicketService;
import org.springframework.stereotype.Component;

@Component
public class TicketServiceFailure implements TicketService {
    @Override
    public Ticket create(CreateTicketDto dto) {
        return null;
    }
}
