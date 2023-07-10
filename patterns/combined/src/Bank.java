public class Bank implements IObserver {
  private static Bank INSTANCE;

  public static synchronized Bank getInstance() {
    if (INSTANCE == null) {
      INSTANCE = Bank.builder().build();
    }
    return INSTANCE;
  }

  private static BankBuilder builder() {
    return new BankBuilder();
  }

  private Bank() {}

  @Override
  public void update(String name, double oldAccount, double newAccount) {
    System.out.printf("%s's account has changed from %s to %s%n", name, oldAccount, newAccount);
  }

  private static class BankBuilder {

    private Bank build() {
      return new Bank();
    }
  }
}
