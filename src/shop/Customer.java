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

    public double getMoney(){
        return money.doubleValue();
    }

    public BigDecimal getMoneyAsBigDecimal(){
        return BigDecimal.valueOf(money.doubleValue());
    }

    public void increaseMoney(double amount){
        money = getAlteredMoney(amount);
    }

    public void decreaseMoney(double amount){
        money = getAlteredMoney(-amount);
    }

    private BigDecimal getAlteredMoney(double amount){
        return money.add(BigDecimal.valueOf(amount));
    }

    public void enterShop(Shop shop){
        this.shop = shop;
        this.basket = shop.makeBasket();

        shop.addCustomer(this);
    }

}
