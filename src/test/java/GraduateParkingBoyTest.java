import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pojo.Car;

 class GraduateParkingBoyTest {

  @Test
  void park_into_the_first_when_parking_log_is_not_full(){
    GraduateParkingBoy graduateParkingBoy= new GraduateParkingBoy();
    for (int i =0 ;i<11;i++){
      Car car = new Car("0"+i);
      int parkingSpaceNo = graduateParkingBoy.parkingCar(car);
      if(i< 10){
        Assertions.assertThat(parkingSpaceNo).isEqualTo(0);
      }

    }
  }

  @Test
  void park_into_the_next_parking_log_when_currently_parking_log_is_full(){
    GraduateParkingBoy graduateParkingBoy= new GraduateParkingBoy();

    for (int i =0 ;i<11;i++){
      Car car = new Car("0"+i);
      int parkingSpaceNo = graduateParkingBoy.parkingCar(car);
      if(i== 10){
        Assertions.assertThat(parkingSpaceNo).isEqualTo(1);
      }

    }
  }

   @Test
   void pick_up_car_from_parking_space_if_it_exist_in_first_parking_log(){
     GraduateParkingBoy graduateParkingBoy= new GraduateParkingBoy();
     Car car = new Car("007");
     graduateParkingBoy.parkingCar(car);
     Car pickUpCar = graduateParkingBoy.pickUpCar("007");
     Assertions.assertThat(pickUpCar.getCarNO()).isEqualTo("007");
   }


   @Test
   void pick_up_car_from_parking_space_if_it_exist_in_second_parking_log(){
     GraduateParkingBoy graduateParkingBoy= new GraduateParkingBoy();
     for (int i =0 ;i<11;i++){
       Car car = new Car("0"+i);
       graduateParkingBoy.parkingCar(car);
     }
     Car pickUpCar = graduateParkingBoy.pickUpCar("010");
     Assertions.assertThat(pickUpCar.getCarNO()).isEqualTo("010");

   }

   @Test
   void pick_up_car_from_parking_space_if_it_not_exist_when_one_parking_log(){
     GraduateParkingBoy graduateParkingBoy= new GraduateParkingBoy();
     Car car = new Car("007");
     graduateParkingBoy.parkingCar(car);
     Car pickUpCar = graduateParkingBoy.pickUpCar("008");
     Assertions.assertThat(pickUpCar).isEqualTo(null);
   }

   @Test
   void pick_up_car_from_parking_space_if_it_not_exist_when_multiple_parking_log(){
     GraduateParkingBoy graduateParkingBoy= new GraduateParkingBoy();
     for (int i =0 ;i<11;i++){
       Car car = new Car("0"+i);
       graduateParkingBoy.parkingCar(car);
     }
     Car pickUpCar = graduateParkingBoy.pickUpCar("013");
     Assertions.assertThat(pickUpCar).isEqualTo(null);
   }
}
