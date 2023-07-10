public class CarFactory extends MotorVehicleFactory {
  public CarFactory() {
  }

  @Override
  protected MotorVehicle createMotorVehicle() {
    return new Car();
  }
}
