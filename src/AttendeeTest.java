import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by daniel on 2/11/15.
 */
public class AttendeeTest {



    @Test
    public void shouldParkTheCar() {
        Attendee attendee = new Attendee();
        ParkingLot regular = new ParkingLot(1 , ParkingLotType.REGULAR);
        ParkingLot premium = new ParkingLot(5, ParkingLotType.PREMIUM);
        attendee.addParkingLot(regular);
        attendee.addParkingLot(premium);
        Car car = new Car("Bugatti");

        assertEquals(true, attendee.park(car));

    }

    @Test
    public void shouldNotParkTheCar()   {
        Attendee attendee = new Attendee();
        ParkingLot regular = new ParkingLot(1 , ParkingLotType.REGULAR);
        attendee.addParkingLot(regular);
        Car car = new Car("Bugatti");
        attendee.park(car);
        assertEquals(false, attendee.park(new Car("Trident")));
    }

    @Test
    public void shouldParkInFreeSpace() {
        Attendee attendee = new Attendee();
        ParkingLot regular = new ParkingLot(1 , ParkingLotType.REGULAR);
        ParkingLot premium = new ParkingLot(5, ParkingLotType.PREMIUM);
        attendee.addParkingLot(regular);
        attendee.addParkingLot(premium);
        Car car = new Car("Bugatti");
        attendee.park(car, attendee.new FreeSpaceSlotFinder());
        assertEquals(1, regular.freeSlots());
        assertEquals(4, premium.freeSlots());

    }
}
