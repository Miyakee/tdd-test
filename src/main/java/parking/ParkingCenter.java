package parking;

import java.util.ArrayList;
import java.util.List;
import pojo.Car;

public class ParkingCenter {

  private static volatile ParkingCenter parkingCenter = null;
  private List<ParkingLog> parkingLogs = new ArrayList<>();

  public void clearAll() {
    parkingLogs = new ArrayList<>();
    parkingCenter = null;
  }

  private void initParkingLogs(int parkingLogSize) {
    for (int i = parkingLogSize; i > 0; i--) {
      ParkingLog parkingLog = new ParkingLog();
      this.parkingLogs.add(parkingLog);
    }
  }

  public static ParkingCenter getParkingCenter(int parkingLogSize) {
    if (parkingCenter == null) {
      synchronized (ParkingCenter.class) {
        if (parkingCenter == null) {
          parkingCenter = new ParkingCenter();
          parkingCenter.initParkingLogs(parkingLogSize);
          return parkingCenter;
        }
      }
    }
    return parkingCenter;
  }

  public List<ParkingLog> getParkingLogs() {
    return parkingLogs;
  }

  public ParkingTickets parkingCar(int parkingNO, Car car) {
    if (this.getParkingLogs().get(parkingNO).parkingCar(car)) {
      return new ParkingTickets(parkingNO, car.getCarNO());
    }
    return null;
  }

  public Car pickUpCar(ParkingTickets parkingTickets) {
    return this.getParkingLogs().get(parkingTickets.getParkingNo()).pickUpCar(parkingTickets.getCarNO());
  }


}
