package com.thoughtworks.parkinglot.infrastructure.repo.dorepo;

import com.thoughtworks.parkinglot.infrastructure.repo.dataobject.ParkingSpotDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingSpotDoRepo extends JpaRepository<ParkingSpotDO,Integer> {
}
