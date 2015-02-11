import java.util.Comparator;

/**
 * Created by daniel on 2/11/15.
 */
public class FreeSpaceSorter implements Comparator<ParkingLot> {

    @Override
    public int compare(ParkingLot parkingLot, ParkingLot t1) {
        return parkingLot.freeSlots() - t1.freeSlots();
    }
}
