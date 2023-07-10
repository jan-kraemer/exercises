public abstract class CustomerFactory {
  public CustomerFactory() {}

  public Customer create(String name) {
    Customer customer = createCustomer(name);
    customer.create(customer);
    return customer;
  }

  protected abstract Customer createCustomer(String name);
}
