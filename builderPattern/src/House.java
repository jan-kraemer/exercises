public class House {
  private Integer numberOfWalls;
  private Integer numberOfWindows;
  private Flooring flooring;

  public static HouseBuilder builder() {
    return new HouseBuilder();
  }

  public House() {}

  public House(Integer numberOfWalls, Integer numberOfWindows, Flooring flooring) {
    this.numberOfWalls = numberOfWalls;
    this.numberOfWindows = numberOfWindows;
    this.flooring = flooring;
  }

  public Integer getNumberOfWalls() {
    return numberOfWalls;
  }

  public void setNumberOfWalls(Integer numberOfWalls) {
    this.numberOfWalls = numberOfWalls;
  }

  public Integer getNumberOfWindows() {
    return numberOfWindows;
  }

  public void setNumberOfWindows(Integer numberOfWindows) {
    this.numberOfWindows = numberOfWindows;
  }

  public Flooring getFlooring() {
    return flooring;
  }

  public void setFlooring(Flooring flooring) {
    this.flooring = flooring;
  }

  @Override
  public String toString() {
    return "House{"
        + "numberOfWalls="
        + this.numberOfWalls
        + ", numberOfWindows="
        + this.numberOfWindows
        + ", flooring="
        + this.flooring
        + '}';
  }

  public static class HouseBuilder {
    private Integer numberOfWalls;
    private Integer numberOfWindows;
    private Flooring flooring;

    public HouseBuilder() {}

    public HouseBuilder numberOfWalls(Integer numberOfWalls) {
      this.numberOfWalls = numberOfWalls;
      return this;
    }

    public HouseBuilder numberOfWindows(Integer numberOfWindows) {
      this.numberOfWindows = numberOfWindows;
      return this;
    }

    public HouseBuilder flooring(Flooring flooring) {
      this.flooring = flooring;
      return this;
    }

    public House build() {
      return new House(this.numberOfWalls, this.numberOfWindows, this.flooring);
    }

    @Override
    public String toString() {
      return "HouseBuilder{"
          + "numberOfWalls="
          + this.numberOfWalls
          + ", numberOfWindows="
          + this.numberOfWindows
          + ", flooring="
          + this.flooring
          + '}';
    }
  }
}
