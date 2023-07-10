import java.util.ArrayList;
import java.util.List;

public class CustomerTypeStrategyRepository {
  private static CustomerTypeStrategyRepository INSTANCE;
  private final List<CustomerTypeStrategy> customerTypeStrategies;

  public static synchronized CustomerTypeStrategyRepository getInstance() {
    if (INSTANCE == null) {
      INSTANCE = CustomerTypeStrategyRepository.builder().build();
    }
    return INSTANCE;
  }

  private static CustomerTypeStrategyRepositoryBuilder builder() {
    return new CustomerTypeStrategyRepositoryBuilder();
  }

  private CustomerTypeStrategyRepository() {
    customerTypeStrategies =
        new ArrayList<>(List.of(NormalStrategy.getInstance(), PremiumStrategy.getInstance()));
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

  private static class CustomerTypeStrategyRepositoryBuilder {
    private CustomerTypeStrategyRepository build() {
      return new CustomerTypeStrategyRepository();
    }
  }
}
