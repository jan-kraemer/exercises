public class House {
  private static House INSTANCE;
  private final String tmp;

  public static synchronized House getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new House();
    }
    return INSTANCE;
  }

  private House() {
    this.tmp = "TMP";
  }

  public String getTmp() {
    return tmp;
  }
}
