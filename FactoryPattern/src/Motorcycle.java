public class Motorcycle implements MotorVehicle {
  private Integer numberOfSeats;

  public Motorcycle() {}

  @Override
  public Integer getNumberOfSeats() {
    return this.numberOfSeats;
  }

  @Override
  public void build() {
    setNumberOfSeats(1);
    System.out.println(this);
  }

  public void setNumberOfSeats(Integer numberOfSeats) {
    this.numberOfSeats = numberOfSeats;
  }

  @Override
  public String toString() {
    return "Motorcycle{" + "numberOfSeats=" + numberOfSeats + '}';
  }
}
