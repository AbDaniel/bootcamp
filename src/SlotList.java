import java.util.ArrayList;

/**
 * Created by daniel on 2/10/15.
 */
public class SlotList extends ArrayList<Car> {

    public enum Event {
        FULL,
        FREE,
        ALMOST_FULL
    }

    private Event event;


    public static final int THRESHOLD_PERCENTAGE = 75;
    int capacity;


    private ParkingLot lot;

    public Event getEvent() {
        return event;
    }


    SlotList(ParkingLot lot, int capacity) {
        this.lot = lot;
        this.capacity = capacity;
        this.event = Event.FREE;
    }


    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;

    }


    @Override
    public Car remove(int i) {
        Car car = null;
        try {
            car = super.remove(i);
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidTokenException();
        }
        return car;
    }

    @Override
    public boolean add(Car e) {
        if (capacity == this.size())
            throw new CapacityFullException();
        boolean success = super.add(e);
        return success;
    }

    @Override
    public boolean remove(Object e) {
        Car car = (Car) e;
        boolean success = false;
        try {
            success = super.remove(e);
        } catch (Exception ex) {
            throw new InvalidTokenException();
        }
        return success;
    }

    public boolean isSlotFull() {
        return this.size() == capacity;

    }

}
