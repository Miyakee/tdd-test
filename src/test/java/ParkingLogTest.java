import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pojo.Car;

 class ParkingLogTest {

  @Test
  void park_car_success_when_currently_parking_log_is_not_full(){
    ParkingLog parkingLog= new ParkingLog();
    Car car = new Car("001");
    boolean isParkSuccess = parkingLog.parkingCar(car);
    Assertions.assertThat(isParkSuccess).isEqualTo(true);
  }
  @Test
  void park_car_fail_when_currently_parking_log_is_full(){
    ParkingLog parkingLog= new ParkingLog();
    for (int i =0 ;i<11;i++) {
      Car car = new Car("0" + i);
      boolean isParkSuccess = parkingLog.parkingCar(car);
      if (i == 10) {
        Assertions.assertThat(isParkSuccess).isEqualTo(false);
      }
    }
  }

   @Test
   void pick_up_car_when_the_car_parking_in_parking_log(){
     ParkingLog parkingLog= new ParkingLog();
     Car car = new Car("001");
     parkingLog.parkingCar(car);
     Car pickUpCar = parkingLog.pickUpCar("001");
     Assertions.assertThat(pickUpCar.getCarNO()).isEqualTo(car.getCarNO());

   }

   @Test
   void pick_up_null_when_the_car_parking_not_in_parking_log(){
     ParkingLog parkingLog= new ParkingLog();
     Car car = new Car("001");
     parkingLog.parkingCar(car);
     Car pickUpCar = parkingLog.pickUpCar("003");
     Assertions.assertThat(pickUpCar).isEqualTo(null);

   }
}
