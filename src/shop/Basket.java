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

    protected int countItems(){
        return products.size();
    }

}
