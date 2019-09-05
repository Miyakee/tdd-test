package people;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import parking.ParkingCenter;
import pojo.Car;
import parking.ParkingTickets;

 class PakingBoyTest {
   private ParkingCenter parkingCenter;
   @AfterEach
   void setUp(){
     parkingCenter.clearAll();
   }
  @Test
  void pick_up_car_from_parking_space_if_it_exist_in_second_parking_log(){
    GraduateParkingBoy graduateParkingBoy= new GraduateParkingBoy();
     parkingCenter = ParkingCenter.getParkingCenter(5);
    for (int i =0 ;i<11;i++){
      Car car = new Car("0"+i);
      if(i == 10) {
        ParkingTickets parkingTickets = graduateParkingBoy.parkingCar(car,parkingCenter);
        Car pickUpCar = graduateParkingBoy.pickUpCar(parkingTickets,parkingCenter);
        Assertions.assertThat(pickUpCar.getCarNO()).isEqualTo("010");

      }
    }

  }

  @Test
  void pick_up_car_from_parking_space_if_it_not_exist_when_one_parking_log(){
    GraduateParkingBoy graduateParkingBoy= new GraduateParkingBoy();
     parkingCenter = ParkingCenter.getParkingCenter(5);
    Car car = new Car("007");
    graduateParkingBoy.parkingCar(car,parkingCenter);
    Car pickUpCar = graduateParkingBoy.pickUpCar(new ParkingTickets(0,"008"),parkingCenter);
    Assertions.assertThat(pickUpCar).isEqualTo(null);
  }

  @Test
  void pick_up_car_from_parking_space_if_parking_log_number_is_not_exist(){
    GraduateParkingBoy graduateParkingBoy= new GraduateParkingBoy();
     parkingCenter = ParkingCenter.getParkingCenter(5);
    for (int i =0 ;i<11;i++){
      Car car = new Car("0"+i);
      graduateParkingBoy.parkingCar(car,parkingCenter);
    }
    Car pickUpCar = graduateParkingBoy.pickUpCar(new ParkingTickets(5,"008"),parkingCenter);
    Assertions.assertThat(pickUpCar).isEqualTo(null);
  }
}
