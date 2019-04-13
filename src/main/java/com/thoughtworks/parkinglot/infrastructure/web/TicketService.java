package com.thoughtworks.parkinglot.infrastructure.web;

import com.thoughtworks.parkinglot.domain.entity.Ticket;
import com.thoughtworks.parkinglot.infrastructure.web.dto.CreateTicketDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "ticket-service", url = "${ticket-service.url}")
@Component
public interface TicketService {

    @RequestMapping(value = "/tickets",method = RequestMethod.POST)
    Ticket create(@RequestBody CreateTicketDto dto);
}
