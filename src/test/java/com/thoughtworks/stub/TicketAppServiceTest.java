package com.thoughtworks.stub;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
@SpringBootApplication
@AutoConfigureWireMock
public  class TicketAppServiceTest {
    public static void main(String[] args) {
        SpringApplication.run(TicketAppServiceTest.class, args);
    }
}
