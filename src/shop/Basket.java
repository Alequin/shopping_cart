package shop;

import Products.Product;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Basket {

    private ArrayList<Product> products;
    private Stock shopStock;

    protected Basket(Stock shopStock){
        this.shopStock = shopStock;
        this.products = new ArrayList<Product>();
    }

    protected String getShopName(){
        return shopStock.getShopName();
    }

    protected void add(int stockIndex){
        Product toAdd = shopStock.remove(stockIndex);
        products.add(toAdd);
    }

    protected void remove(int basketIndex){
        Product toMoveToStock = products.remove(basketIndex);
        shopStock.add(toMoveToStock);
    }

    protected void remove(Class type){
        int length = products.size();
        for(int j=length-1; j>=0; j--){
            if(products.get(j).getClass() == type){
                remove(j);
            }
        }
    }

    protected void empty(){
        for(Product product : products){
            shopStock.add(product);
        }
        products.clear();
    }

    protected int countItems(){
        return products.size();
    }

    protected int countItems(Class type){
        int sum = 0;
        int length = products.size();
        for (Product product : products) {
            if (product.getClass() == type) {
                sum++;
            }
        }
        return sum;
    }

    protected double getTotalCost(){
        BigDecimal cost = BigDecimal.ZERO;
        for (Product product : products) {
            cost = cost.add(product.getCostAsBigDecimal());
        }
        return cost.doubleValue();
    }

    public double getTotalCostWithDiscount() {

        BigDecimal cost = Discount.getCostWithTwoForOneDiscount(shopStock, products);

        if(cost.doubleValue() > Discount.discountLimit){
            return Discount.getDiscountForOverLimit(cost).doubleValue();
        }else {
            return cost.doubleValue();
        }
    }
}
