public interface CustomerTypeStrategy {
  double calculateAccountAfterInterest(double account);

  boolean supports(CustomerType customerType);
}
