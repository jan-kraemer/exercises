public class Main {
  public static void main(String[] args) {
    CarFactory carFactory = new CarFactory();
    carFactory.create();

    MotorcycleFactory motorcycleFactory = new MotorcycleFactory();
    motorcycleFactory.create();
  }
}
