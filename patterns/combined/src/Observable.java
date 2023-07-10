import java.util.ArrayList;
import java.util.List;

public abstract class Observable {
  List<IObserver> IObservers;

  public Observable() {
    this.IObservers = new ArrayList<>();
  }

  public void addObserver(IObserver IObserver) {
    this.IObservers.add(IObserver);
  }

  public void removeObserver(IObserver IObserver) {
    this.IObservers.remove(IObserver);
  }

  public void notifyOberservers(String name, double oldAccount, double newAccount) {
    for (IObserver IObserver : IObservers) {
      IObserver.update(name, oldAccount, newAccount);
    }
  }
}
