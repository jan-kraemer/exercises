public class CustomerFactoryImpl extends CustomerFactory {
  private static CustomerFactoryImpl INSTANCE;

  public static synchronized CustomerFactoryImpl getInstance() {
    if (INSTANCE == null) {
      INSTANCE = CustomerFactoryImpl.builder().build();
    }
    return INSTANCE;
  }

  private static CustomerFactoryImplBuilder builder() {
    return new CustomerFactoryImplBuilder();
  }

  private CustomerFactoryImpl() {}

  @Override
  protected Customer createCustomer(String name) {
    return Customer.builder()
        .name(name)
        .observer(Bank.getInstance())
        .customerTypeStrategyRepository(CustomerTypeStrategyRepository.getInstance())
        .build();
  }

  private static class CustomerFactoryImplBuilder {
    private CustomerFactoryImpl build() {
      return new CustomerFactoryImpl();
    }
  }
}
