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

    public boolean isInStock(Product product){
        return products.contains(product);
    }

    public boolean isInStock(Class type){
        for(Product product : products){
            if(product.getClass() == type){
                return true;
            }
        }
        return false;
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

    public Product[] empty(Class type) {
        Product[] result = removeProductsOfType(type);
        itemCounter.remove(type);
        return result;
    }

    private Product[] removeProductsOfType(Class type){
        int resultIndex = 0;
        Product[] result = new Product[countItems(type)];
        int length = products.size();

        for(int j=length-1; j>=0; j--){
            Product product = products.get(j);
            if(product.getClass() == type){
                result[resultIndex++] = products.remove(j);
            }
        }
        return result;
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

        if(productCount == 0){
            itemCounter.remove(productClass);
        }else{
            itemCounter.put(productClass, productCount);
        }
    }
}
