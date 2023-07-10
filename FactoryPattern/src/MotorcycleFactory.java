public class MotorcycleFactory extends MotorVehicleFactory {
  public MotorcycleFactory() {
  }

  @Override
  protected MotorVehicle createMotorVehicle() {
    return new Motorcycle();
  }
}
