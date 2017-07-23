package shop;

import java.math.BigDecimal;

public class Shop {

    private String name;
    private BigDecimal money;

    public Shop(String name, double money){
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
