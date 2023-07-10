public class Bank implements IObserver {
  private static Bank INSTANCE;

  private Bank() {}

  public static BankBuilder builder() {
    return new BankBuilder();
  }

  public static synchronized Bank getInstance() {
    if (INSTANCE == null) {
      INSTANCE = Bank.builder().build();
    }
    return INSTANCE;
  }

  @Override
  public void update(String name, double oldAccount, double newAccount) {
    System.out.printf("%s's account has changed from %s to %s%n", name, oldAccount, newAccount);
  }

  public static class BankBuilder {

    public Bank build() {
      return new Bank();
    }
  }
}
