package shop;

import Products.Product;

import java.util.ArrayList;

public class Basket {

    private ArrayList<Product> products;
    private Stock shopStock;

    protected Basket(Stock shopStock){
        this.shopStock = shopStock;
        this.products = new ArrayList<Product>();
    }

    protected void add(int stockIndex){
        Product toAdd = shopStock.remove(stockIndex);
        products.add(toAdd);
    }

    protected void remove(int basketIndex){
        Product toMoveToStock = products.remove(basketIndex);
        shopStock.add(toMoveToStock);
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

}
