package people;

import parking.ParkingCenter;
import pojo.Car;
import parking.ParkingTickets;

public class GraduateParkingBoy extends ParkingBoy{

  public ParkingTickets parkingCar(Car car , ParkingCenter parkingCenter) {
    int parkingCenterSize = parkingCenter.getParkingLogs().size();
    for (int i = 0; i < parkingCenterSize; i++) {
      if (!parkingCenter.getParkingLogs().get(i).isFull()) {
        return parkingCenter.parkingCar(i,car);
      }
    }
    return null;
  }
}
