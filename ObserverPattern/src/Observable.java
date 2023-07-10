import java.util.ArrayList;
import java.util.List;

public abstract class Observable {
  List<Observer> observers;

  public Observable() {
    this.observers = new ArrayList<>();
  }

  public void addObserver(Observer observer) {
    this.observers.add(observer);
  }

  public void removeObserver(Observer observer) {
    this.observers.remove(observer);
  }

  public void notifyOberservers(String name, double oldAccount, double newAccount) {
    for (Observer observer : observers) {
      observer.update(name, oldAccount, newAccount);
    }
  }
}
