import java.util.ArrayList;
import java.util.List;
import pojo.Car;

public class GraduateParkingBoy {
  private List<ParkingLog> parkingLogs;
  private int currentlyParkingSpace = 0;

  public GraduateParkingBoy() {
    List<ParkingLog> parkingLogs = new ArrayList<>();
    parkingLogs.add(new ParkingLog());
    this.parkingLogs = parkingLogs;
  }

  public int parkingCar(Car car){
    if(!parkingLogs.get(currentlyParkingSpace).parkingCar(car)){
      ParkingLog newParkingLog = new ParkingLog();
      newParkingLog.parkingCar(car);
      parkingLogs.add(newParkingLog);
      this.currentlyParkingSpace++;
    }
    return this.currentlyParkingSpace;
  }

  public Car pickUpCar(String carNO){
    for (ParkingLog parkingLog:parkingLogs){
      Car car = parkingLog.pickUpCar(carNO);
      if(car!=null){
        return car;
      }
    }
    return null;
  }

}
