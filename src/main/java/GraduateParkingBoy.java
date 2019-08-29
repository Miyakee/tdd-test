import java.util.ArrayList;
import java.util.List;
import pojo.Car;
import pojo.ParkingTickets;

public class GraduateParkingBoy {
  private List<ParkingLog> parkingLogs;

  public GraduateParkingBoy() {
    List<ParkingLog> parkingLogs = new ArrayList<>();
    parkingLogs.add(new ParkingLog());
    this.parkingLogs = parkingLogs;
  }

  public ParkingTickets parkingCar(Car car){
    int currentlyParkingLogSize = parkingLogs.size();
    if(!parkingLogs.get(currentlyParkingLogSize-1).parkingCar(car)){
      ParkingLog newParkingLog = new ParkingLog();
      newParkingLog.parkingCar(car);
      parkingLogs.add(newParkingLog);
      currentlyParkingLogSize++;
    }
    return new ParkingTickets(currentlyParkingLogSize,car.getCarNO());

  }

  public Car pickUpCar(ParkingTickets parkingTickets){
    return parkingLogs.size() >= parkingTickets.getParkingNo() && parkingLogs.size()>0
        ?parkingLogs.get(parkingTickets.getParkingNo()-1).pickUpCar(parkingTickets.getCarNO())
        : null;
  }

}
