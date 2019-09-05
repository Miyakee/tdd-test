package people;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import parking.ParkingCenter;
import people.GraduateParkingBoy;
import people.SmartParkingBoy;
import pojo.Car;
import parking.ParkingTickets;

 class SmartParkingBoyTest {
  private ParkingCenter parkingCenter;
  @AfterEach
  void setUp(){
    parkingCenter.clearAll();
  }
  @Test
  void park_into_NO1_parking_log_when_NO1_is_less_cars(){
     parkingCenter = ParkingCenter.getParkingCenter(2);
    GraduateParkingBoy graduateParkingBoy= new GraduateParkingBoy();
    Car car = new Car("001");
    graduateParkingBoy.parkingCar(car,parkingCenter);
    SmartParkingBoy smartParkingBoy= new SmartParkingBoy();
    Car carForSmartBoy = new Car("002");
    ParkingTickets parkingTickets = smartParkingBoy.parkingCar(carForSmartBoy,parkingCenter);
    Assertions.assertThat(parkingTickets.getParkingNo()).isEqualTo(1);
  }

  @Test
  void pick_up_car_when_last_case_parking(){
     parkingCenter = ParkingCenter.getParkingCenter(2);
    SmartParkingBoy smartParkingBoy= new SmartParkingBoy();
    Car carForSmartBoy = new Car("003");
    ParkingTickets parkingTickets = smartParkingBoy.parkingCar(carForSmartBoy,parkingCenter);
    Car car = smartParkingBoy.pickUpCar(parkingTickets,parkingCenter);
    Assertions.assertThat(car.getCarNO()).isEqualTo("003");
  }
}
