package Products;

import java.math.BigDecimal;

public abstract class Product {

    private String name;
    private BigDecimal cost;

    public Product(String name, double cost){
        this.name = name;
        this.cost = BigDecimal.valueOf(cost);
    }

    public String getName(){
        return name;
    }

    public double getCost(){
        return cost.doubleValue();
    }

    public void setCost(double cost){
        this.cost = BigDecimal.valueOf(cost);
    }
}


