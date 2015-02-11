import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by daniel on 2/10/15.
 */
public class ParkingLot implements Comparable<ParkingLot> {


    private SlotList slots;
    private ParkingLotType type;
    int size;

    public ParkingLot(int size, ParkingLotType type) {
        slots = new SlotList(this, size);
        this.size = size;
        this.type = type;
    }

    public boolean park(Car car) {
        int token = -1;
        slots.add(car);
        token = slots.size();
        if(token > 0)
            return true;
        else
            return false;
    }

    public boolean removeCar(Car car) {
        boolean success = slots.remove(car);
        return success;
    }

    public boolean isFull() {
        return slots.isSlotFull();
    }

    public int freeSlots()  {
        return size - slots.size();
    }

    @Override
    public int compareTo(ParkingLot parkingLot) {

        return Double.compare(this.type.getCost(), parkingLot.type.getCost());
    }


}
