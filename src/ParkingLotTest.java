import org.junit.Test;

import java.security.Security;

import static org.junit.Assert.assertEquals;

/**
 * Created by daniel on 2/10/15.
 */
public class ParkingLotTest {

    @Test
    public void shouldParkCar() {
        ParkingLot lot = new ParkingLot(1,ParkingLotType.PREMIUM);
        assertEquals(true, lot.park(new Car("Fiat")));
    }


    @Test
    public void shouldRemoveCar() {
        ParkingLot lot = new ParkingLot(1,ParkingLotType.REGULAR);
        Car car = new Car("Bugati");
        lot.park(car);
        assertEquals(true, lot.removeCar(car));
    }





}
