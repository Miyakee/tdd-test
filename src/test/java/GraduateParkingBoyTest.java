import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pojo.Car;
import pojo.ParkingTickets;

class GraduateParkingBoyTest {

  @Test
  void park_into_the_first_when_parking_log_is_not_full(){
    GraduateParkingBoy graduateParkingBoy= new GraduateParkingBoy();
    for (int i =0 ;i<11;i++){
      Car car = new Car("0"+i);
      ParkingTickets parkingTickets = graduateParkingBoy.parkingCar(car);
      if(i< 10){
        Assertions.assertThat(parkingTickets.getParkingNo()).isEqualTo(1);
      }

    }
  }

  @Test
  void park_into_the_next_parking_log_when_currently_parking_log_is_full(){
    GraduateParkingBoy graduateParkingBoy= new GraduateParkingBoy();

    for (int i =0 ;i<11;i++){
      Car car = new Car("0"+i);
      ParkingTickets parkingTickets = graduateParkingBoy.parkingCar(car);
      if(i== 10){
        Assertions.assertThat(parkingTickets.getParkingNo()).isEqualTo(2);
      }

    }
  }

   @Test
   void pick_up_car_from_parking_space_if_it_exist_in_first_parking_log(){
     GraduateParkingBoy graduateParkingBoy= new GraduateParkingBoy();
     Car car = new Car("007");
     graduateParkingBoy.parkingCar(car);
     ParkingTickets parkingTickets= new ParkingTickets(1,"007");
     Car pickUpCar = graduateParkingBoy.pickUpCar(parkingTickets);
     Assertions.assertThat(pickUpCar.getCarNO()).isEqualTo("007");
   }


   @Test
   void pick_up_car_from_parking_space_if_it_exist_in_second_parking_log(){
     GraduateParkingBoy graduateParkingBoy= new GraduateParkingBoy();
     for (int i =0 ;i<11;i++){
       Car car = new Car("0"+i);
       if(i == 10) {
         ParkingTickets parkingTickets = graduateParkingBoy.parkingCar(car);
         Car pickUpCar = graduateParkingBoy.pickUpCar(parkingTickets);
         Assertions.assertThat(pickUpCar.getCarNO()).isEqualTo("010");

       }
     }

   }

   @Test
   void pick_up_car_from_parking_space_if_it_not_exist_when_one_parking_log(){
     GraduateParkingBoy graduateParkingBoy= new GraduateParkingBoy();
     Car car = new Car("007");
     graduateParkingBoy.parkingCar(car);
     Car pickUpCar = graduateParkingBoy.pickUpCar(new ParkingTickets(1,"008"));
     Assertions.assertThat(pickUpCar).isEqualTo(null);
   }

   @Test
   void pick_up_car_from_parking_space_if_parking_log_number_is_not_exist(){
     GraduateParkingBoy graduateParkingBoy= new GraduateParkingBoy();
     for (int i =0 ;i<11;i++){
       Car car = new Car("0"+i);
       graduateParkingBoy.parkingCar(car);
     }
     Car pickUpCar = graduateParkingBoy.pickUpCar(new ParkingTickets(6,"008"));
     Assertions.assertThat(pickUpCar).isEqualTo(null);
   }
}
