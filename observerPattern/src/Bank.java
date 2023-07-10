public class Bank implements Observer {
  @Override
  public void update(String name, double oldAccount, double newAccount) {
    System.out.printf("%s's account has changed from %s to %s%n", name, oldAccount, newAccount);
  }
}
