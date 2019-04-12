package com.thoughtworks.parkinglot.domain.aggregate.ticket.repo;

import com.thoughtworks.parkinglot.domain.entity.Ticket;

public interface TicketRepo {
    void save(Ticket t);
}
