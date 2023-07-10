public class Main {
  public static void main(String[] args) {
    DiscountStrategy[] discountStrategies = {new ChristmasStrategy(), new EasternStrategy()};

    for (DiscountStrategy discountStrategy : discountStrategies) {
      if (discountStrategy.supports(Holiday.EASTERN)) {
        discountStrategy.discount(100);
      }
    }
  }
}
