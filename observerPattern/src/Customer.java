import java.beans.PropertyChangeSupport;

public class Customer extends Observable {
  private String name;
  private double account;

  public Customer(String name) {
    this.name = name;
  }

  public Customer(String name, Observer observer) {
    this.name = name;
    addObserver(observer);
  }

  public double getAccount() {
    return account;
  }

  public void setAccount(double account) {
    notifyOberservers(this.name, getAccount(), account);
    this.account = account;
  }
}
