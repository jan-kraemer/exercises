public class PremiumStrategy implements CustomerTypeStrategy {
  private static PremiumStrategy INSTANCE;
  private static final double PERCENT = 0.05;

  public static synchronized PremiumStrategy getInstance() {
    if (INSTANCE == null) {
      INSTANCE = PremiumStrategy.builder().build();
    }
    return INSTANCE;
  }

  private static PremiumStrategyBuilder builder() {
    return new PremiumStrategyBuilder();
  }

  private PremiumStrategy() {}

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

  private static class PremiumStrategyBuilder {
    private PremiumStrategy build() {
      return new PremiumStrategy();
    }
  }
}
