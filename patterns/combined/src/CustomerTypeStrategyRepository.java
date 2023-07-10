import java.util.ArrayList;
import java.util.List;

public class CustomerTypeStrategyRepository {
  public static CustomerTypeStrategyRepository INSTANCE;
  private final List<CustomerTypeStrategy> customerTypeStrategies;

  public CustomerTypeStrategyRepository() {
    customerTypeStrategies =
        new ArrayList<>(
            List.of(NormalStrategy.builder().build(), PremiumStrategy.builder().build()));
  }

  public static CustomerTypeStrategyRepositoryBuilder builder() {
    return new CustomerTypeStrategyRepositoryBuilder();
  }

  public static CustomerTypeStrategyRepository getInstance() {
    if (INSTANCE == null) {
      INSTANCE = CustomerTypeStrategyRepository.builder().build();
    }
    return INSTANCE;
  }

  public CustomerTypeStrategy findStrategyByCustomerType(CustomerType customerType) {
    return customerTypeStrategies.stream()
        .filter(customerTypeStrategy -> customerTypeStrategy.supports(customerType))
        .findFirst()
        .orElseThrow();
  }

  @Override
  public String toString() {
    return "CustomerTypeStrategyRepository{"
        + "customerTypeStrategies="
        + customerTypeStrategies
        + '}';
  }

  public static class CustomerTypeStrategyRepositoryBuilder {
    public CustomerTypeStrategyRepository build() {
      return new CustomerTypeStrategyRepository();
    }
  }
}
