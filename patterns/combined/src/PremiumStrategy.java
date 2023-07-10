public class PremiumStrategy implements CustomerTypeStrategy {
  private static final double PERCENT = 0.05;

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
    return CustomerType.PREMIUM.equals(customerType);
  }

  public static class NormalStrategyBuilder {
    public PremiumStrategy build() {
      return new PremiumStrategy();
    }
  }
}
