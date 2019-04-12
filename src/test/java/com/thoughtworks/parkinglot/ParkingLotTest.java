//package com.thoughtworks.parkinglot;
//
//
//import com.thoughtworks.parkinglot.domain.entity.Ticket;
//import com.thoughtworks.parkinglot.domain.aggregate.parkingboy.ParkingLot;
//import com.thoughtworks.parkinglot.domain.entity.NoParkingSpotException;
//import com.thoughtworks.parkinglot.domain.entity.TakeCarException;
//import org.junit.Assert;
//import org.junit.Test;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class ParkingLotTest {
//
//    @Test
//    public void parkOneCar_should_return_one_ticket(){
//
//        String car="川A888888";
//
//        Ticket returnTicket= new ParkingLot(1).parkOneCar(car);
//
//        Assert.assertNotNull(returnTicket);
//    }
//
//    @Test
//    public void takeOneCar_should_return_a_car(){
//        ParkingLot pl=new ParkingLot(1);
//        String car="川A888888";
//
//
//        Ticket ticket= pl.parkOneCar(car);
//        String takedCar=pl.takeOneCar(ticket.getId());
//
//        Assert.assertEquals(car,takedCar);
//
//    }
//
//    @Test
//    public void partMultiCars_should_return_three_tickets(){
//        ParkingLot pl=new ParkingLot(3);
//
//        String[] cars=new String[]{"川A888888","川A999999","川A000000"};
//
//
//        List<Ticket> returnTickets=pl.parkMultiCars(Arrays.asList(cars));
//        Assert.assertEquals(cars.length,returnTickets.size());
//
//    }
//
//    @Test
//    public void takeMultiCars_should_return_three_cars(){
//        ParkingLot pl=new ParkingLot(3);
//
//
//        String[] cars=new String[]{"川A888888","川A999999","川A000000"};
//
//
//        List<Ticket> returnTickets=pl.parkMultiCars(Arrays.asList(cars));
//
//        List<String> ticketIds= returnTickets.stream().map(Ticket::getId).collect(Collectors.toList());
//
//        String[] takedCars=pl.takeMultiCars(ticketIds);
//        Assert.assertArrayEquals(cars,takedCars);
//    }
//
//
//    @Test(expected = NoParkingSpotException.class )
//    public void parkOneCar_should_exception_when_parkinglot_has_car(){
//
//        String car="川A888888";
//        String car2="川A00000";
//        ParkingLot pl=new ParkingLot(1);
//        pl.parkOneCar(car);
//
//        pl.parkOneCar(car2);
//
//    }
//    @Test(expected = TakeCarException.class)
//    public void takeOneCar_should_exception_when_ticketId_invalid() {
//        ParkingLot pl = new ParkingLot(1);
//        String car = "川A888888";
//
//        pl.parkOneCar(car);
//        pl.takeOneCar("xxxx-bbbb");
//
//    }
//
//    @Test(expected = TakeCarException.class)
//    public void takeOneCar_should_exception_when_takeCar_twice() {
//        ParkingLot pl = new ParkingLot(1);
//        String car = "川A888888";
//
//        Ticket ticket = pl.parkOneCar(car);
//        pl.takeOneCar(ticket.getId());
//        pl.takeOneCar(ticket.getId());
//    }
//
//}
