//package com.thoughtworks.parkinglot;
//
//import com.thoughtworks.parkinglot.domain.entity.Ticket;
//import com.thoughtworks.parkinglot.domain.aggregate.parkingboy.ParkingLot;
//import com.thoughtworks.parkinglot.domain.aggregate.parkingboy.SmartParkingBody;
//import com.thoughtworks.parkinglot.domain.entity.NoParkingSpotException;
//import com.thoughtworks.parkinglot.domain.entity.TakeCarException;
//import org.junit.Assert;
//import org.junit.Test;
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class SmartParkingBoyTest {
//
//    @Test
//    public void bodyPark_should_return_a_ticket() {
//
//        SmartParkingBody spl = new SmartParkingBody(Arrays.asList(new ParkingLot(1)));
//
//        Ticket ticket = spl.boyPark("川A00000");
//
//        Assert.assertNotNull(ticket);
//
//    }
//
//    @Test
//    public void bodyPark_should_in_first_when_first_has_more_spot() {
//
//        List<ParkingLot> lots = Arrays.asList(new ParkingLot(2), new ParkingLot(1));
//        SmartParkingBody spl = new SmartParkingBody(lots);
//
//
//        Ticket ticket = spl.boyPark("川A00000");
//
//        Assert.assertEquals(ticket.getLotId(), lots.get(0).getId());
//
//    }
//
//    @Test
//    public void bodyPark_should_in_second_when_second_has_more_spot() {
//
//        List<ParkingLot> lots = Arrays.asList(new ParkingLot(1), new ParkingLot(2));
//        SmartParkingBody spl = new SmartParkingBody(lots);
//
//        Ticket ticket = spl.boyPark("川A00000");
//
//        Assert.assertEquals(ticket.getLotId(), lots.get(1).getId());
//
//    }
//
//    @Test
//    public void bodyParks_should_in_both_when_both_same() {
//
//        List<ParkingLot> lots = Arrays.asList(new ParkingLot(2), new ParkingLot(2));
//        SmartParkingBody spl = new SmartParkingBody(lots);
//
//
//        List<Ticket> tickets = spl.boyParks(Arrays.asList("川A0001", "川B0002"));
//
//
//        Assert.assertEquals(2, tickets.stream().map(Ticket::getLotId).collect(Collectors.toSet()).size());
//
//    }
//
//    @Test(expected = NoParkingSpotException.class)
//    public void bodyParks_should_exception_when_both_full() {
//
//        List<ParkingLot> lots = Arrays.asList(new ParkingLot(1), new ParkingLot(1));
//        SmartParkingBody spl = new SmartParkingBody(lots);
//
//
//        spl.boyParks(Arrays.asList("川A0001", "川B0002"));
//
//        spl.boyParks(Arrays.asList("川A0003", "川B0004"));
//    }
//
//
//    @Test
//
//    public void takeCar_should_return_a_car() {
//        List<ParkingLot> lots = Arrays.asList(new ParkingLot(1), new ParkingLot(1));
//        SmartParkingBody spl = new SmartParkingBody(lots);
//        Ticket ticket = spl.boyPark("川A0001");
//        Assert.assertEquals("川A0001",spl.takeCar(ticket));
//    }
//
//    @Test
//    public void takeCar_should_return_a_car_when_parking_multi_car() {
//        List<ParkingLot> lots = Arrays.asList(new ParkingLot(1), new ParkingLot(1));
//        SmartParkingBody spl = new SmartParkingBody(lots);
//        List<Ticket> tickets = spl.boyParks(Arrays.asList("川A0001", "川B0002"));
//        Assert.assertNotNull(spl.takeCar(tickets.get(1)));
//    }
//
//    @Test(expected = TakeCarException.class)
//    public void takeCar_should_exception_when_ticket_invalid() {
//        List<ParkingLot> lots = Arrays.asList(new ParkingLot(1), new ParkingLot(1));
//        SmartParkingBody spl = new SmartParkingBody(lots);
//
//        spl.takeCar(new Ticket());
//    }
//    @Test(expected = TakeCarException.class)
//    public void takeCar_should_exception_when_ticket_take_twice() {
//        List<ParkingLot> lots = Arrays.asList(new ParkingLot(1), new ParkingLot(1));
//        SmartParkingBody spl = new SmartParkingBody(lots);
//
//        Ticket ticket = spl.boyPark("川A0001");
//
//        spl.takeCar(ticket);
//        spl.takeCar(ticket);
//    }
//}
