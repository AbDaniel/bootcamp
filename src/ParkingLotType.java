/**
 * Created by daniel on 2/10/15.
 */
public enum ParkingLotType {

    REGULAR(20.0), PREMIUM(30.0);

    double cost;

    ParkingLotType(double cost) {
        this.cost = cost;
    }


    public double getCost() {
        return cost;
    }
}
