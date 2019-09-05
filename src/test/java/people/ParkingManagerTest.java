package people;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import parking.ParkingCenter;
import people.GraduateParkingBoy;
import people.PakingManager;
import people.SmartParkingBoy;
import pojo.Car;
import parking.ParkingTickets;

 class ParkingManagerTest {
  private ParkingCenter parkingCenter ;
   @AfterEach
   void setUp(){
     parkingCenter.clearAll();
   }
  @Test
  void park_into_NO1_parking_log_utill_NO1_is_not_full_when_by_he_self(){
     parkingCenter = ParkingCenter.getParkingCenter(2);
    PakingManager pakingManager = new PakingManager();
    for (int i =0 ;i<10;i++){
      Car car = new Car("0"+i);
      ParkingTickets parkingTickets = pakingManager.parkingCar(car,parkingCenter);
      Assertions.assertThat(parkingTickets.getParkingNo()).isEqualTo(1);
    }
  }

  @Test
  void park_into_NO0_parking_log_half_and_NO1_half_when_let_smart_parking_boy(){
     parkingCenter = ParkingCenter.getParkingCenter(2);
    PakingManager pakingManager = new PakingManager();
    pakingManager.assignParkingBoy(new SmartParkingBoy());
    for (int i =0 ;i<10;i++){
      Car car = new Car("0"+i);
      ParkingTickets parkingTickets = pakingManager.parkingCar(car,parkingCenter);
      Assertions.assertThat(parkingTickets.getParkingNo()).isEqualTo(i%2);
    }
  }


  @Test
  void park_into_NO0_parking_log_utill_NO0_is_not_full_when_let_graduate_parking_boy(){
     parkingCenter = ParkingCenter.getParkingCenter(2);
    PakingManager pakingManager = new PakingManager();
    pakingManager.assignParkingBoy(new GraduateParkingBoy());
    for (int i =0 ;i<10;i++){
      Car car = new Car("0"+i);
      ParkingTickets parkingTickets = pakingManager.parkingCar(car,parkingCenter);
      Assertions.assertThat(parkingTickets.getParkingNo()).isEqualTo(0);
    }
  }

}
