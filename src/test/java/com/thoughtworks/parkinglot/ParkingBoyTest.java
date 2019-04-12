//package com.thoughtworks.parkinglot;
//
//import com.thoughtworks.parkinglot.domain.aggregate.parkingboy.ParkingBoy;
//import com.thoughtworks.parkinglot.domain.entity.Ticket;
//import com.thoughtworks.parkinglot.domain.aggregate.parkingboy.ParkingLot;
//import com.thoughtworks.parkinglot.domain.entity.NoParkingSpotException;
//import org.junit.Assert;
//import org.junit.Test;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class ParkingBoyTest {
//
//    @Test
//    public void bodyParkCar_should_return_ticket() {
//
//        List<ParkingLot> lots = new ArrayList<>();
//        lots.add(new ParkingLot(1));
//
//        ParkingBoy boy = new ParkingBoy(lots);
//        String car = "川Axxx";
//        Ticket ticket = boy.boyPark(car);
//
//        Assert.assertNotNull(ticket);
//    }
//
//    @Test
//    public void bodyParkCars_should_in_first_when_multi_cars() {
//
//        List<ParkingLot> lots = new ArrayList<>();
//        lots.add(new ParkingLot(100));
//        lots.add(new ParkingLot(100));
//
//        ParkingBoy boy = new ParkingBoy(lots);
//        List<String> cars = Arrays.asList("川A434", "川Axxx");
//        List<Ticket> tickets = boy.boyParks(cars);
//
//        Assert.assertEquals(2, tickets.size());
//        Assert.assertEquals(lots.get(0).getId(), tickets.get(0).getLotId());
//        Assert.assertEquals(lots.get(0).getId(), tickets.get(1).getLotId());
//    }
//
//    @Test
//    public void bodyParkCars_should_in_two_slots() {
//
//        List<ParkingLot> lots = new ArrayList<>();
//        lots.add(new ParkingLot(2));
//        lots.add(new ParkingLot(1));
//
//        ParkingBoy boy = new ParkingBoy(lots);
//        List<String> cars = Arrays.asList("川Axx4", "川009xx", "川A43545");
//        List<Ticket> tickets = boy.boyParks(cars);
//
//        Assert.assertEquals(3, tickets.size());
//        Assert.assertEquals(lots.get(0).getId(), tickets.get(0).getLotId());
//        Assert.assertEquals(lots.get(0).getId(), tickets.get(1).getLotId());
//        Assert.assertEquals(lots.get(1).getId(), tickets.get(2).getLotId());
//    }
//
//    @Test
//    public void bodyParkCar_should_in_sencond() {
//        List<ParkingLot> lots = new ArrayList<>();
//        lots.add(new ParkingLot(1));
//        lots.add(new ParkingLot(1));
//        lots.get(0).parkOneCar("川Axx4");
//
//        ParkingBoy boy = new ParkingBoy(lots);
//
//        boy.boyPark("川A6543");
//    }
//
//    @Test
//    public void bodyParkCars_should_in_seccond() {
//
//        List<ParkingLot> lots = new ArrayList<>();
//        lots.add(new ParkingLot(1));
//        lots.add(new ParkingLot(2));
//        lots.get(0).parkOneCar("川Axx4");
//
//        ParkingBoy boy = new ParkingBoy(lots);
//        List<String> cars = Arrays.asList("川009xx", "川A43545");
//        List<Ticket> tickets = boy.boyParks(cars);
//
//        Assert.assertEquals(2, tickets.size());
//        Assert.assertEquals(lots.get(1).getId(), tickets.get(0).getLotId());
//        Assert.assertEquals(lots.get(1).getId(), tickets.get(1).getLotId());
//    }
//
//    @Test(expected = NoParkingSpotException.class)
//    public void bodyParkCar_should_exception_when_lot_both_full() {
//        List<ParkingLot> lots = new ArrayList<>();
//        lots.add(new ParkingLot(1));
//        lots.add(new ParkingLot(1));
//        lots.get(0).parkOneCar("川Axx4");
//        lots.get(1).parkOneCar("川Axx4xx");
//
//        ParkingBoy boy = new ParkingBoy(lots);
//
//        boy.boyPark("川A6543");
//    }
//
//    @Test
//    public void bodyTake_should_return_a_car() {
//        List<ParkingLot> lots = new ArrayList<>();
//        lots.add(new ParkingLot(1));
//
//        ParkingBoy boy = new ParkingBoy(lots);
//        String car = "川A678x";
//        Ticket ticket = boy.boyPark(car);
//
//        String returnCar = boy.takeCar(ticket);
//        Assert.assertEquals(car, returnCar);
//    }
//
//    @Test
//    public void bodyTakeCar_should_return_car_from_sencond() {
//        List<ParkingLot> lots = new ArrayList<>();
//        lots.add(new ParkingLot(1));
//        lots.add(new ParkingLot(1));
//
//
//        Ticket ticket = lots.get(1).parkOneCar("川A0010");
//
//        ParkingBoy boy = new ParkingBoy(lots);
//
//        String returnCar = boy.takeCar(ticket);
//        Assert.assertEquals("川A0010", returnCar);
//    }
//
//}
