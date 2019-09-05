package people;

import parking.ParkingCenter;
import pojo.Car;
import parking.ParkingTickets;

public class SmartParkingBoy extends ParkingBoy{

  public ParkingTickets parkingCar(Car car , ParkingCenter parkingCenter){
   int smallestParkingLogNO = 0;
   int smallestParkingCars = parkingCenter.getParkingLogs().get(0).carSize();
    int parkingCenterSize = parkingCenter.getParkingLogs().size();
    for (int i = 1; i < parkingCenterSize; i++) {
      if(parkingCenter.getParkingLogs().get(i).carSize()<smallestParkingCars){
        smallestParkingLogNO=i;
      }
    }
    return parkingCenter.parkingCar(smallestParkingLogNO,car);
  }

}
