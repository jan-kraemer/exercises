public class Main {
  public static void main(String[] args) {
    Bank bank = new Bank();
    Customer jan = new Customer("Jan", bank);
    Customer luca = new Customer("Luca", bank);
    Customer natalie = new Customer("Natalie");
    jan.setAccount(100);
    natalie.setAccount(50);
    luca.setAccount(50);
  }
}
