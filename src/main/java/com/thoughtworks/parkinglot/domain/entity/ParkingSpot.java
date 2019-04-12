package com.thoughtworks.parkinglot.domain.entity;

import com.thoughtworks.parkinglot.domain.DomainEntity;

public class ParkingSpot implements DomainEntity {
    private String no;
    private String parkedCar;
    private String lotId;

    public String getLotId() {
        return lotId;
    }

    public void setLotId(String lotId) {
        this.lotId = lotId;
    }

    public String getParkedCar() {
        return parkedCar;
    }

    public void setParkedCar(String parkedCar) {
        this.parkedCar = parkedCar;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

}
