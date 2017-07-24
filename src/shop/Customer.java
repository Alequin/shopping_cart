package shop;

import java.math.BigDecimal;

public class Customer {

    private static final String NOT_IN_SHOP_MESSAGE = "The customer is not in a shop";

    private BigDecimal money;
    private boolean hasLoyaltyCard;

    private Basket basket;
    private Shop shop;

    public Customer(double money, boolean hasLoyaltyCard){
        this.money = BigDecimal.valueOf(money);
        this.hasLoyaltyCard = hasLoyaltyCard;
    }

    public void setHasLoyaltyCard(boolean state){
        this.hasLoyaltyCard = state;
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

    public int countBasketItems() {
        if(basket == null){
            throw new IllegalStateException(NOT_IN_SHOP_MESSAGE);
        }
        return basket.countItems();
    }

    public void addToBasket(int index) {
        if(basket == null){
            throw new IllegalStateException(NOT_IN_SHOP_MESSAGE);
        }
        basket.add(index);
    }

    public void removeFromBasket(int index) {
        if(basket == null){
            throw new IllegalStateException(NOT_IN_SHOP_MESSAGE);
        }
        basket.remove(index);
    }

    public double getCostOfItems() {
        if(basket == null){
            throw new IllegalStateException(NOT_IN_SHOP_MESSAGE);
        }
        return basket.getTotalCost();
    }

    public double getCostOfItemsWithDiscount() {
        if(basket == null){
            throw new IllegalStateException(NOT_IN_SHOP_MESSAGE);
        }

        BigDecimal cost = BigDecimal.valueOf(basket.getTotalCostWithDiscount());

        if(hasLoyaltyCard){
            return Discount.getDiscountWithLoyaltyCard(cost).doubleValue();
        }else{
            return cost.doubleValue();
        }
    }
}
