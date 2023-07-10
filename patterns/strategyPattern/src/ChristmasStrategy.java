public class ChristmasStrategy implements DiscountStrategy {
  public ChristmasStrategy() {}

  @Override
  public void discount(Integer price) {
    System.out.printf(
        "The new price, after deduction of 15%% is as follows %s - Old Price: %s",
        price - (price * 0.15), price);
  }

  @Override
  public boolean supports(Holiday holiday) {
    return Holiday.CHRISTMAS.equals(holiday);
  }
}
