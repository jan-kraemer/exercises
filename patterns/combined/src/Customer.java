public class Customer extends Observable implements ICustomer {
  private final String name;
  private double account;
  private CustomerType type;
  private final CustomerTypeStrategyRepository customerTypeStrategyRepository;

  public static CustomerBuilder builder() {
    return new CustomerBuilder();
  }

  public Customer(
      String name,
      double account,
      IObserver iObserver,
      CustomerType type,
      CustomerTypeStrategyRepository customerTypeStrategyRepository) {
    this.name = name;
    this.account = account;
    this.type = type;
    this.customerTypeStrategyRepository = customerTypeStrategyRepository;
    addObserver(iObserver);
  }

  public double getAccount() {
    return account;
  }

  public void depositMoney(double account) {
    double newAccount =
        getAccount()
            + customerTypeStrategyRepository
                .findStrategyByCustomerType(getType())
                .calculateAccountAfterInterest(account);
    notifyOberservers(this.name, getAccount(), newAccount);
    this.account = newAccount;
    setType();
  }

  public void payOutMoney(double account) {
    double newAccount = getAccount() - account;
    notifyOberservers(this.name, getAccount(), newAccount);
    this.account = newAccount;
    setType();
  }

  public CustomerType getType() {
    return type;
  }

  public void setType() {
    if (account >= 200) {
      setType(CustomerType.PREMIUM);
    } else {
      setType(CustomerType.NORMAL);
    }
  }

  public void setType(CustomerType type) {
    this.type = type;
  }

  @Override
  public void create(ICustomer iCustomer) {
    iCustomer.setType();
  }

  @Override
  public String toString() {
    return "Customer{"
        + "name='"
        + name
        + '\''
        + ", account="
        + account
        + ", type="
        + type
        + ", customerTypeStrategyRepository="
        + customerTypeStrategyRepository
        + ", IObservers="
        + IObservers
        + '}';
  }

  public static class CustomerBuilder {
    private String name;
    private double account;
    private IObserver iObserver;
    private CustomerType type;
    private CustomerTypeStrategyRepository customerTypeStrategyRepository;

    public CustomerBuilder name(String name) {
      this.name = name;
      return this;
    }

    public CustomerBuilder account(double account) {
      this.account = account;
      return this;
    }

    public CustomerBuilder observer(IObserver iObserver) {
      this.iObserver = iObserver;
      return this;
    }

    public CustomerBuilder type(CustomerType type) {
      this.type = type;
      return this;
    }

    public CustomerBuilder customerTypeStrategyRepository(
        CustomerTypeStrategyRepository customerTypeStrategyRepository) {
      this.customerTypeStrategyRepository = customerTypeStrategyRepository;
      return this;
    }

    public Customer build() {
      return new Customer(name, account, iObserver, type, customerTypeStrategyRepository);
    }
  }
}
