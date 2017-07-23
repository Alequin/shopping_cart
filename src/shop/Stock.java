package shop;

import Products.Pizza;
import Products.Product;

import java.util.ArrayList;

public class Stock {

    private ArrayList<Product> products;

    public Stock(){
        products = new ArrayList<>();
    }

    public void add(Product product) {
        if(products.contains(product)){
            return;
        }
        products.add(product);
    }

    public int countItems() {
        return products.size();
    }

    public Product remove(int index) {
        return products.remove(index);
    }

    public Product[] empty() {
        Product[] tempProducts = products.toArray(new Product[products.size()]);
        products.clear();
        return tempProducts;
    }
}
