package parking;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import parking.ParkingCenter;
import pojo.Car;
import parking.ParkingTickets;

public class ParkingCenterTest {
  private ParkingCenter parkingCenter;
  @AfterEach
  void setUp(){
    parkingCenter.clearAll();
  }

  @Test
  void parking_should_return_ticket_when_this_parkingNO_is_not_full(){
    parkingCenter= ParkingCenter.getParkingCenter(2);
    ParkingTickets parkingTickets = parkingCenter.parkingCar(0,new Car("001"));
    Assertions.assertThat(parkingTickets.getParkingNo()).isEqualTo(0);
  }

  @Test
  void parking_should_return_null_when_this_parkingNO_is_full(){
    parkingCenter= ParkingCenter.getParkingCenter(2);
    for (int i=0;i<10;i++){
     parkingCenter.parkingCar(0,new Car("00"+i));
    }
    ParkingTickets parkingTickets = parkingCenter.parkingCar(0,new Car("001"));
    Assertions.assertThat(parkingTickets).isEqualTo(null);
  }

  @Test
  void picking_should_return_car_when_this_ticket_is_exist(){
    parkingCenter= ParkingCenter.getParkingCenter(2);
    ParkingTickets parkingTickets = parkingCenter.parkingCar(0,new Car("001"));
    Car car = parkingCenter.pickUpCar(parkingTickets);
    Assertions.assertThat(car.getCarNO()).isEqualTo("001");
  }

  @Test
  void picking_should_return_null_when_this_ticket_is_no_exist(){
    parkingCenter= ParkingCenter.getParkingCenter(2);
    ParkingTickets parkingTickets = parkingCenter.parkingCar(0,new Car("001"));
    Car car = parkingCenter.pickUpCar(new ParkingTickets(0,"003"));
    Assertions.assertThat(car).isEqualTo(null);
  }
}
