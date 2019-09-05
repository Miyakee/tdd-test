package parking;

public class ParkingTickets {
  private int parkingNo;
  private String carNO;

  public ParkingTickets(int parkingNo, String carNO) {
    this.parkingNo = parkingNo;
    this.carNO = carNO;
  }

  public int getParkingNo() {
    return parkingNo;
  }

  public String getCarNO() {
    return carNO;
  }

}
