public class NormalStrategy implements CustomerTypeStrategy {
  private static final double PERCENT = 0.1;

  public static NormalStrategyBuilder builder() {
    return new NormalStrategyBuilder();
  }

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

  public static class NormalStrategyBuilder {
    public NormalStrategy build() {
      return new NormalStrategy();
    }
  }
}
