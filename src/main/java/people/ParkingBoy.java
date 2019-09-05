package people;

import parking.ParkingCenter;
import pojo.Car;
import parking.ParkingTickets;

 abstract class ParkingBoy {
   abstract ParkingTickets parkingCar(Car car , ParkingCenter parkingCenter);

   Car pickUpCar(ParkingTickets parkingTickets, ParkingCenter parkingCenter){
     return parkingCenter.getParkingLogs().size() > parkingTickets.getParkingNo() && parkingCenter.getParkingLogs().size()>0
         ?parkingCenter.pickUpCar(parkingTickets)
         : null;
   }
}
