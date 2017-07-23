package shop_test;

import Products.Crisps;
import Products.Pizza;
import Products.Product;
import Products.ToothPaste;
import org.junit.Before;
import org.junit.Test;
import shop.Stock;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class StockTest {

    private Stock stock1;
    private Product[] products;

    @Before
    public void setup(){
        stock1 = new Stock();

        Product p1 = new Pizza(10);
        Product p2 = new Crisps(10);
        Product p3 = new ToothPaste(10);
        Product[] tempProducts = {p1, p2, p3};
        products = tempProducts;
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
        int expected1 = 0;
        int result1 = stock1.countItems();
        assertEquals(expected1, result1);

        for(int j=0; j<3; j++){
            stock1.add(products[j]);
            expected1++;
            result1 = stock1.countItems();
            assertEquals(expected1, result1);
        }
    }

    @Test
    public void cannotAddExistingProductsToStock(){
        for(int j=0; j<3; j++){
            stock1.add(products[j]);
        }

        int preAddCount = stock1.countItems();
        for(int j=0; j<3; j++){
            stock1.add(products[j]);
        }
        assertEquals(preAddCount, stock1.countItems());
    }

    @Test
    public void canEmptyBasket(){
        for(int j=0; j<3; j++){
            stock1.add(products[j]);
        }
        Product[] stockProducts = stock1.empty();
        assertEquals(0, stock1.countItems());
        assertArrayEquals(products, stockProducts);
    }
}