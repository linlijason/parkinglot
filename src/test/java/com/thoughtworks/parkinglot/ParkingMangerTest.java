//package com.thoughtworks.parkinglot;
//
//import com.thoughtworks.parkinglot.domain.aggregate.parkingboy.ParkingBoy;
//import com.thoughtworks.parkinglot.domain.entity.Ticket;
//import com.thoughtworks.parkinglot.domain.aggregate.parkingboy.ParkingLot;
//import com.thoughtworks.parkinglot.domain.aggregate.parkingboy.ParkingManager;
//import com.thoughtworks.parkinglot.domain.aggregate.parkingboy.SmartParkingBody;
//import com.thoughtworks.parkinglot.domain.entity.NoParkingSpotException;
//import org.junit.Assert;
//import org.junit.Test;
//
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
//public class ParkingMangerTest {
//
//    @Test
//    public void parkCar_Should_return_a_ticket_when_no_boy_has_lot(){
//
//        ParkingManager manager=new ParkingManager(Arrays.asList(new ParkingLot(1)));
//
//        Ticket t=manager.boyPark("川A0009");
//
//        Assert.assertNotNull(t);
//    }
//    @Test(expected = NoParkingSpotException.class)
//    public void parkCars_Should_exception_when_park_2cars_and_noboy_haslot(){
//
//        ParkingManager manager=new ParkingManager(Arrays.asList(new ParkingLot(1)));
//
//        manager.boyParks(Arrays.asList("川A0009","川A00010"));
//
//    }
//    @Test()
//    public void parkCars_Should_return_2Tickets_when_park_2cars_and_noboy_haslot(){
//
//        ParkingManager manager=new ParkingManager(Arrays.asList(new ParkingLot(2)));
//
//        List<Ticket> ts= manager.boyParks(Arrays.asList("川A0009","川A00010"));
//
//        Assert.assertEquals(2,ts.size());
//
//    }
//
//    /*
//    ------
//     */
//
//    @Test
//    public void parkCar_should_return_a_ticket_when_1boy_noLot(){
//
//        SmartParkingBody boy=new SmartParkingBody(Arrays.asList(new ParkingLot(1)));
//        ParkingManager manager=new ParkingManager(Collections.emptyList(),Arrays.asList(boy));
//
//       Ticket t= manager.boyPark("川A333");
//       Assert.assertNotNull(t);
//    }
//    @Test
//    public void parkCar_should_return_a_ticket_when_2boy_onlyOnehasLot_noLot(){
//
//        SmartParkingBody boy=new SmartParkingBody(Arrays.asList(new ParkingLot(0)));
//        ParkingBoy boy1=new ParkingBoy(Arrays.asList(new ParkingLot(1)));
//        ParkingManager manager=new ParkingManager(Collections.emptyList(),Arrays.asList(boy,boy1));
//
//        Ticket t= manager.boyPark("川A333");
//        Assert.assertNotNull(t);
//    }
//
//    @Test(expected = NoParkingSpotException.class)
//    public void parkCar_should_exception_when_1boyhas2_and_1boynolot_noLot(){
//
//        SmartParkingBody boy=new SmartParkingBody(Arrays.asList(new ParkingLot(2)));
//        ParkingBoy boy1=new ParkingBoy(Arrays.asList(new ParkingLot(0)));
//        ParkingManager manager=new ParkingManager(Collections.emptyList(),Arrays.asList(boy,boy1));
//
//        List<Ticket> t= manager.boyParks(Arrays.asList("1","2","3"));
//
//        Assert.assertEquals(3,t.size());
//    }
//
//     /*
//    ------
//     */
//
//    @Test
//    public void parkCar_should_return_2tickets_when_1boyhas1_and_selfhas1(){
//
//        SmartParkingBody boy=new SmartParkingBody(Arrays.asList(new ParkingLot(1)));
//
//        ParkingManager manager=new ParkingManager(Arrays.asList(new ParkingLot(1)),Arrays.asList(boy));
//
//        List<Ticket> t= manager.boyParks(Arrays.asList("1","2"));
//
//        Assert.assertEquals(2,t.size());
//    }
//
//}
