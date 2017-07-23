package shop;

import java.math.BigDecimal;

public class Shop {

    private String name;
    private BigDecimal money;
    private Stock stock;

    public Shop(String name, double money){
        if(money < 0){
            throw new IllegalArgumentException("Money cannot be less than 0. Current money: " + money);
        }

        this.name = name;
        this.money = BigDecimal.valueOf(money);
        this.stock = new Stock();
    }

    public String getName(){
        return name;
    }

    public double getMoney(){
        return money.doubleValue();
    }

    public Stock getStock(){
        return stock;
    }

    public void increaseMoney(double toAdd) {
        money = money.add(BigDecimal.valueOf(toAdd));
    }

    public void decreaseMoney(double toSubtract) {
        money = money.subtract(BigDecimal.valueOf(toSubtract));
    }
}
