import java.util.concurrent.ConcurrentHashMap;
import pojo.Car;

public class ParkingLog {
  private ConcurrentHashMap<String, Car> parkingSpaces = new ConcurrentHashMap<>();
  private int size=10;


   boolean parkingCar(Car car){
    if(this.parkingSpaces.size()<10){
      this.parkingSpaces.put(car.getCarNO(),car);
      return true;
    }
    return false;
  }

   Car pickUpCar(String carNO){
    return this.parkingSpaces.get(carNO);
  }


}
