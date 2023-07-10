public interface DiscountStrategy {
    void discount(Integer price);
    boolean supports(Holiday holiday);
}
