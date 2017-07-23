package shop;

import java.math.BigDecimal;

public class Customer {

    private BigDecimal money;
    private boolean hasLoyaltyCard;

    private Basket basket;
    private Shop shop;

    public Customer(double money, boolean hasLoyaltyCard){
        this.money = BigDecimal.valueOf(money);
        this.hasLoyaltyCard = hasLoyaltyCard;
    }

}
