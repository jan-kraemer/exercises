public class EasternStrategy implements DiscountStrategy {
  public EasternStrategy() {}

  @Override
  public void discount(Integer price) {
    System.out.printf(
        "The new price, after deduction of 50%% is as follows %s - Old Price: %s",
        price - (price * 0.50), price);
  }

  @Override
  public boolean supports(Holiday holiday) {
    return Holiday.EASTERN.equals(holiday);
  }
}
