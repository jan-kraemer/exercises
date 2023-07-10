public class Main {
  public static void main(String[] args) {
    House house =
        House.builder().numberOfWindows(1).numberOfWalls(4).flooring(Flooring.STONE).build();
    System.out.println(house);

    House.HouseBuilder houseBuilder =
        House.builder().numberOfWindows(1).numberOfWalls(4).flooring(Flooring.STONE);
    System.out.println(houseBuilder);
  }
}
