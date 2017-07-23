package shop_test;

import Products.Pizza;
import org.junit.Before;
import org.junit.Test;
import shop.Stock;

import static junit.framework.TestCase.assertEquals;

public class StockTest {

    private Stock stock1;

    @Before
    public void setup(){
        stock1 = new Stock();
    }

    @Test
    public void canAddAndRemoveItem(){
        Pizza pizza = new Pizza(6.50);
        int preLength = stock1.countItems();
        stock1.addItem(pizza);
        assertEquals(preLength, stock1.countItems());
        assertEquals(pizza, stock1.remove(0));
    }
}