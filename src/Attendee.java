import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by daniel on 2/10/15.
 */
public class Attendee {

    List<ParkingLot> parking = new ArrayList<ParkingLot>();
    private SlotFinder finder;

    Attendee() {
        finder = new CheapSlotFinder();
    }

    public boolean park(Car car) {
        ParkingLot lot = finder.find();
        if (lot == null)
            return false;
        return lot.park(car);
    }


    public boolean park(Car car, SlotFinder finder) {
        ParkingLot lot = finder.find();
        if (lot == null)
            return false;
        return lot.park(car);
    }

    public void addParkingLot(ParkingLot lot) {
        parking.add(lot);
    }


    public class CheapSlotFinder implements SlotFinder {
        @Override
        public ParkingLot find() {
            Collections.sort(parking);
            ParkingLot cheapLot = null;
            boolean success = false;
            for (ParkingLot lot : parking) {
                if (!lot.isFull()) {
                    cheapLot = lot;
                }
            }
            return cheapLot;
        }
    }

    public class FreeSpaceSlotFinder implements SlotFinder {
        @Override
        public ParkingLot find() {
            Collections.sort(parking, new FreeSpaceSorter());
            ParkingLot cheapLot = null;
            boolean success = false;
            for (ParkingLot lot : parking) {
                if (!lot.isFull()) {
                    cheapLot = lot;
                }
            }
            return cheapLot;
        }
    }


}
