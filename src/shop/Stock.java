package shop;

import Products.Product;

import java.util.ArrayList;
import java.util.HashMap;

public class Stock {

    private ArrayList<Product> products;
    private HashMap<Class, Integer> itemCounter;

    public Stock(){
        products = new ArrayList<>();
        itemCounter = new HashMap<>();
    }

    public void add(Product product) {
        if(products.contains(product)){
            return;
        }

        addOneToItemCount(product);
        products.add(product);
    }

    public int countItems() {
        return products.size();
    }

    public int countItems(Class type) {
        Integer count = itemCounter.get(type);
        return count == null ? 0 : count;
    }

    public Product remove(int index) {
        Product product = products.remove(index);
        subtractOneFromItemCount(product);
        return product;
    }

    public Product[] empty() {
        Product[] tempProducts = products.toArray(new Product[products.size()]);
        products.clear();
        itemCounter.clear();
        return tempProducts;
    }

    private void addOneToItemCount(Product product){
        alterItemCount(product, 1);
    }

    private void subtractOneFromItemCount(Product product){
        alterItemCount(product, -1);
    }

    private void alterItemCount(Product product, int amount){
        Class productClass = product.getClass();

        Integer productCount = itemCounter.get(productClass);
        productCount = productCount == null ? 1 : productCount + amount;

        itemCounter.put(productClass, productCount);
    }
}
