public class Main {
  public static void main(String[] args) {
    CustomerFactoryImpl customerFactory = CustomerFactoryImpl.builder().build();

    Customer jan = customerFactory.create("Jan");
    Customer luca = customerFactory.create("Luca");
    Customer natalie = customerFactory.create("Natalie");

    jan.depositMoney(100);
    luca.depositMoney(50);
    natalie.depositMoney(50);
    luca.payOutMoney(10);
    natalie.payOutMoney(20);
    jan.depositMoney(300);
    jan.depositMoney(100);
  }
}
