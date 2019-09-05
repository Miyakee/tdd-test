package people;

import parking.ParkingCenter;
import pojo.Car;
import parking.ParkingTickets;

public class PakingManager extends ParkingBoy {
  private ParkingBoy parkingBoy = null;

  public void assignParkingBoy(ParkingBoy parkingBoy){
    this.parkingBoy = parkingBoy;
  }

  ParkingTickets parkingCar(Car car , ParkingCenter parkingCenter){
    int parkingCenterSize = parkingCenter.getParkingLogs().size();
    if(parkingBoy == null){
      for (int i = parkingCenterSize-1; i >=0 ; i--) {
        if (!parkingCenter.getParkingLogs().get(i).isFull()) {
          return parkingCenter.parkingCar(i,car);
        }
      }
      return null;
    }else {
      return parkingBoy.parkingCar(car, parkingCenter);
    }
  }

}
