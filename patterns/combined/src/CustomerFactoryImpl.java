public class CustomerFactoryImpl extends CustomerFactory {

  public CustomerFactoryImpl() {}

  public static CustomerFactoryImplBuilder builder() {
    return new CustomerFactoryImplBuilder();
  }

  @Override
  protected Customer createCustomer(String name) {
    return Customer.builder()
        .name(name)
        .observer(Bank.getInstance())
        .customerTypeStrategyRepository(CustomerTypeStrategyRepository.getInstance())
        .build();
  }

  public static class CustomerFactoryImplBuilder {
    public CustomerFactoryImpl build() {
      return new CustomerFactoryImpl();
    }
  }
}
