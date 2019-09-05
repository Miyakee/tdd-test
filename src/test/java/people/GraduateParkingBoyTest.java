package people;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import parking.ParkingCenter;
import people.GraduateParkingBoy;
import pojo.Car;
import parking.ParkingTickets;

class GraduateParkingBoyTest {
  private ParkingCenter parkingCenter;
  @AfterEach
  void setUp(){
    parkingCenter.clearAll();
  }

  @Test
  void park_into_the_first_when_parking_log_is_not_full(){
     parkingCenter = ParkingCenter.getParkingCenter(5);
    GraduateParkingBoy graduateParkingBoy= new GraduateParkingBoy();
    for (int i =0 ;i<10;i++){
      Car car = new Car("0"+i);
      ParkingTickets parkingTickets = graduateParkingBoy.parkingCar(car,parkingCenter);
      Assertions.assertThat(parkingTickets.getParkingNo()).isEqualTo(0);
    }
  }

  @Test
  void park_into_the_next_parking_log_when_currently_parking_log_is_full(){
    GraduateParkingBoy graduateParkingBoy= new GraduateParkingBoy();
     parkingCenter = ParkingCenter.getParkingCenter(5);

    for (int i =0 ;i<11;i++){
      Car car = new Car("0"+i);
      ParkingTickets parkingTickets = graduateParkingBoy.parkingCar(car,parkingCenter);
      if(i == 10){
        Assertions.assertThat(parkingTickets.getParkingNo()).isEqualTo(1);
      }

    }
  }

   @Test
   void pick_up_car_from_parking_space_if_it_exist_in_first_parking_log(){
     GraduateParkingBoy graduateParkingBoy= new GraduateParkingBoy();
     ParkingCenter parkingCenter = ParkingCenter.getParkingCenter(5);
     Car car = new Car("007");
     graduateParkingBoy.parkingCar(car,parkingCenter);
     ParkingTickets parkingTickets= new ParkingTickets(0,"007");
     Car pickUpCar = graduateParkingBoy.pickUpCar(parkingTickets,parkingCenter);
     Assertions.assertThat(pickUpCar.getCarNO()).isEqualTo("007");
   }

}
