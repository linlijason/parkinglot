package com.thoughtworks.parkinglot.infrastructure.repo.dataobject;

import com.thoughtworks.parkinglot.domain.entity.ParkingSpot;

import javax.persistence.*;

@Entity
@Table(name = "park_spot")
public class ParkingSpotDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "lot_id")
    private String lotId;

    private String name;
    private String car;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLotId() {
        return lotId;
    }

    public void setLotId(String lotId) {
        this.lotId = lotId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }
    public ParkingSpot toDomainEntity(){
        ParkingSpot ps=new ParkingSpot();
        ps.setLotId(lotId);
        ps.setParkedCar(car);
        ps.setNo(id+"");
        return ps;
    }

}
