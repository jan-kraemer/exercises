public class Car implements MotorVehicle {
  private Integer numberOfSeats;

  public Car() {}

  @Override
  public Integer getNumberOfSeats() {
    return this.numberOfSeats;
  }

  @Override
  public void build() {
    setNumberOfSeats(4);
    System.out.println(this);
  }

  public void setNumberOfSeats(Integer numberOfSeats) {
    this.numberOfSeats = numberOfSeats;
  }

  @Override
  public String toString() {
    return "Car{" + "numberOfSeats=" + numberOfSeats + '}';
  }
}
