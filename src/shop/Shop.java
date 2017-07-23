package shop;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Shop {

    private String name;
    private BigDecimal money;
    private Stock stock;

    private ArrayList<Customer> customers;

    public Shop(String name, double money){
        if(money < 0){
            throw new IllegalArgumentException("Money cannot be less than 0. Current money: " + money);
        }

        this.name = name;
        this.money = BigDecimal.valueOf(money);
        this.stock = new Stock(name);
        this.customers = new ArrayList<>();
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

    public Basket makeBasket(){
        return new Basket(stock);
    }

    public void increaseMoney(double toAdd) {
        money = money.add(BigDecimal.valueOf(toAdd));
    }

    public void decreaseMoney(double toSubtract) {
        money = money.subtract(BigDecimal.valueOf(toSubtract));
    }

    public int countCustomers(){
        return customers.size();
    }

    public Customer[] getCustomers(){
        return customers.toArray(new Customer[customers.size()]);
    }

    protected void addCustomer(Customer customer){
        customers.add(customer);
    }

    protected void removeCustomer(Customer customer){
        customers.remove(customer);
    }
}
