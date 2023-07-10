public class NormalStrategy implements CustomerTypeStrategy {
  private static NormalStrategy INSTANCE;
  private static final double PERCENT = 0.1;

  public static synchronized NormalStrategy getInstance() {
    if (INSTANCE == null) {
      INSTANCE = NormalStrategy.builder().build();
    }
    return INSTANCE;
  }

  private static NormalStrategyBuilder builder() {
    return new NormalStrategyBuilder();
  }

  private NormalStrategy() {}

  @Override
  public double calculateAccountAfterInterest(double account) {
    double interest = account * PERCENT;
    System.out.printf(
        "Interest in the amount of %s%% [%s] will be deducted!%n", PERCENT * 100, interest);
    return account - interest;
  }

  @Override
  public boolean supports(CustomerType customerType) {
    return CustomerType.NORMAL.equals(customerType);
  }

  private static class NormalStrategyBuilder {
    private NormalStrategy build() {
      return new NormalStrategy();
    }
  }
}
