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
    public void canGetAssociatedShopName(){
        String expected1 = "The Shop";
        String result1 = basket1.getShopName();
        assertEquals(expected1, result1);
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
    public void canAddToBasket__OtherIndex(){
        int preAddLength = basket1.countItems();

        basket1.add(2);
        basket1.add(1);
        basket1.add(0);

        assertEquals(preAddLength+3, basket1.countItems());
        assertEquals(0, shopStock.countItems());
    }

    @Test
    public void canCountItems(){

        assertEquals(0, basket1.countItems());

        basket1.add(0);
        assertEquals(1, basket1.countItems());

        basket1.add(1);
        assertEquals(2, basket1.countItems());

        basket1.add(0);
        assertEquals(3, basket1.countItems());
    }

    @Test
    public void canCountItemsByType(){
        shopStock.add(new Pizza(2.5));
        basket1.add(1);
        basket1.add(2);
        basket1.add(1);
        basket1.add(0);

        assertEquals(2, basket1.countItems(Pizza.class));
        assertEquals(1, basket1.countItems(Crisps.class));
        assertEquals(1, basket1.countItems(ToothPaste.class));
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

    @Test
    public void canRemoveFromBasket__OtherIndex(){
        basket1.add(0);
        basket1.add(0);
        basket1.add(0);

        int preRemoveBasketCount = basket1.countItems();
        int preRemoveStockCount = shopStock.countItems();

        basket1.remove(2);
        basket1.remove(1);
        basket1.remove(0);

        assertEquals(preRemoveBasketCount-3, basket1.countItems());
        assertEquals(preRemoveStockCount+3, shopStock.countItems());
    }

    @Test
    public void canRemoveFromBasketByType(){
        shopStock.add(new Pizza(2.5));
        basket1.add(0);
        basket1.add(0);
        basket1.add(0);
        basket1.add(0);

        int preRemoveBasketCount = basket1.countItems();
        int preRemoveStockCount = shopStock.countItems();

        basket1.remove(Pizza.class);

        assertEquals(preRemoveBasketCount-2, basket1.countItems());
        assertEquals(preRemoveStockCount+2, shopStock.countItems());

        basket1.remove(Crisps.class);

        assertEquals(preRemoveBasketCount-3, basket1.countItems());
        assertEquals(preRemoveStockCount+3, shopStock.countItems());
    }

    @Test
    public void canEmptyBasket(){
        basket1.add(0);
        basket1.add(0);
        basket1.add(0);

        int preRemoveBasketCount = basket1.countItems();
        int preRemoveStockCount = shopStock.countItems();

        basket1.empty();

        assertEquals(preRemoveBasketCount-3, basket1.countItems());
        assertEquals(preRemoveStockCount+3, shopStock.countItems());
    }

    @Test
    public void getTotalCost(){

        assertEquals(0.0, basket1.getTotalCost());

        basket1.add(0);
        basket1.add(0);
        basket1.add(0);

        assertEquals(30.0, basket1.getTotalCost(), 0.01);
    }

    @Test
    public void getTotalCost_WithPoorNumbers(){

        assertEquals(0.0, basket1.getTotalCost());

        shopStock.add(new Pizza(0.1));
        shopStock.add(new ToothPaste(0.2));

        basket1.add(3);
        basket1.add(3);

        assertEquals(0.3, basket1.getTotalCost(), 0.01);
    }

}