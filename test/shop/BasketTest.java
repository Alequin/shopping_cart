package shop;

import Products.Crisps;
import Products.Pizza;
import Products.Product;
import Products.ToothPaste;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class BasketTest {

    private Shop shop1;
    private Stock shopStock;
    private Basket basket1;
    private Product[] products;

    @Before
    public void setup(){
        shop1 = new Shop("The Shop", 500);
        shopStock = shop1.getStock();
        basket1 = shop1.makeBasket();

        products = new Product[3];
        products[0] = new Pizza(5);
        products[1] = new Crisps(10);
        products[2] = new ToothPaste(15);

        for(Product product : products){
            shopStock.add(product);
        }
    }

    @Test
    public void canAddToBasket(){
        int preAddLength = basket1.countItems();

        basket1.add(0);
        basket1.add(0);
        basket1.add(0);

        assertEquals(preAddLength+3, basket1.countItems());
        assertEquals(0, shopStock.countItems());
    }

    @Test
    public void canRemoveFromBasket(){
        basket1.add(0);
        basket1.add(0);
        basket1.add(0);

        int preRemoveBasketCount = basket1.countItems();
        int preRemoveStockCount = shopStock.countItems();

        basket1.remove(0);
        basket1.remove(0);
        basket1.remove(0);

        assertEquals(preRemoveBasketCount-3, basket1.countItems());
        assertEquals(preRemoveStockCount+3, shopStock.countItems());
    }

}