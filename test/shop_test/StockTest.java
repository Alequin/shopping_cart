package shop_test;

import Products.Crisps;
import Products.Pizza;
import Products.Product;
import Products.ToothPaste;
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
    public void canAddAndRemoveProduct(){
        Pizza pizza = new Pizza(6.50);
        int preLength = stock1.countItems();
        stock1.add(pizza);
        assertEquals(preLength+1, stock1.countItems());
        assertEquals(pizza, stock1.remove(0));
    }

    @Test
    public void canCountProducts(){
        Product p1 = new Pizza(10);
        Product p2 = new Crisps(10);
        Product p3 = new ToothPaste(10);

        int expected1 = 0;
        int result1 = stock1.countItems();
        assertEquals(expected1, result1);

        stock1.add(p1);

        int expected2 = expected1 + 1;
        int result2 = stock1.countItems();
        assertEquals(expected2, result2);

        stock1.add(p2);

        int expected3 = expected2 + 1;
        int result3 = stock1.countItems();
        assertEquals(expected3, result3);

        stock1.add(p3);

        int expected4 = expected3 + 1;
        int result4 = stock1.countItems();
        assertEquals(expected4, result4);

        stock1.add(p1);
        stock1.add(p2);
        stock1.add(p3);

        int result5 = stock1.countItems();
        assertEquals(expected4, result5);
    }
}