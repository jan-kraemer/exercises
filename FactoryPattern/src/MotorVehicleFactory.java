public abstract class MotorVehicleFactory {
  public MotorVehicleFactory() {
  }

  public MotorVehicle create() {
    MotorVehicle vehicle = createMotorVehicle();
    vehicle.build();
    return vehicle;
  }

  protected abstract MotorVehicle createMotorVehicle();
}
