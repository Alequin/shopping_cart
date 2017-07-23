package shop;

import java.math.BigDecimal;

public class Shop {

    private String name;
    private BigDecimal money;

    public Shop(String name, double money){
        if(money < 0){
            throw new IllegalArgumentException("Money cannot be less than 0. Current money: " + money);
        }

        this.name = name;
        this.money = BigDecimal.valueOf(money);
    }

    public String getName(){
        return name;
    }

    public double getMoney(){
        return money.doubleValue();
    }

}
