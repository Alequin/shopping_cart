package shop;

import Products.Crisps;
import Products.Pizza;
import Products.Product;
import Products.ToothPaste;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class StockTest {

    private Stock stock1;
    private Product[] products;

    @Before
    public void setup(){
        stock1 = new Stock("Shop name");

        Product p1 = new Pizza(10);
        Product p2 = new Crisps(10);
        Product p3 = new ToothPaste(10);
        Product[] tempProducts = {p1, p2, p3};
        products = tempProducts;
    }

    @Test
    public void canGetShopName(){
        String expected = "Shop name";
        String result = stock1.getShopName();
        assertEquals(expected, result);
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
    public void canCountProductsOfSpecificType(){
        for(int j=0; j<3; j++){
            stock1.add(products[j]);
        }
        Pizza pizza1 = new Pizza(5);
        stock1.add(pizza1);

        int expected1 = 1;
        int result1 = stock1.countItems(Crisps.class);
        assertEquals(expected1, result1);

        int expected2 = 1;
        int result2 = stock1.countItems(ToothPaste.class);
        assertEquals(expected2, result2);

        int expected3 = 2;
        int result3 = stock1.countItems(Pizza.class);
        assertEquals(expected3, result3);

        stock1.empty();

        int expected4 = 0;
        int result4 = stock1.countItems(Pizza.class);
        assertEquals(expected4, result4);
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

    @Test
    public void canEmptyProductsOfSpecificType(){
        for(int j=0; j<3; j++){
            stock1.add(products[j]);
        }
        Product[] tempProducts = stock1.empty(Pizza.class);

        int expected1 = 0;
        int result1 = stock1.countItems(Pizza.class);
        assertEquals(expected1, result1);

        Product[] expectedArray = {products[0]};
        assertArrayEquals(expectedArray, tempProducts);
    }

    @Test
    public void canCheckIfObjectIsInStock(){
        boolean result1 = stock1.isInStock(products[0]);
        assertEquals(false, result1);

        for(int j=0; j<3; j++){
            stock1.add(products[j]);
        }

        boolean result2 = stock1.isInStock(products[0]);
        assertEquals(true, result2);
    }

    @Test
    public void canCheckIfTypeIsInStock(){
        boolean result1 = stock1.isInStock(Pizza.class);
        assertEquals(false, result1);

        for(int j=0; j<3; j++){
            stock1.add(products[j]);
        }

        boolean result2 = stock1.isInStock(Pizza.class);
        assertEquals(true, result2);
    }

    @Test
    public void canCheckIfProductTypeIsTwoForOne(){
        boolean result1 = stock1.isTwoForOne(Pizza.class);
        assertEquals(false, result1);

        stock1.makeTwoForOne(Pizza.class);

        boolean result2 = stock1.isTwoForOne(Pizza.class);
        assertEquals(true, result2);
    }

    @Test
    public void canMakeItemTwoForOne(){

        for(int j=0; j<3; j++){
            Class prodClass = products[j].getClass();
            assertEquals(false, stock1.isTwoForOne(prodClass));
        }

        for(int j=0; j<3; j++){
            stock1.makeTwoForOne(products[j].getClass());
        }

        for(int j=0; j<3; j++){
            Class prodClass = products[j].getClass();
            assertEquals(true, stock1.isTwoForOne(prodClass));
        }
    }

    @Test
    public void canRemoveItemFromTwoForOneDeal(){

        for(int j=0; j<3; j++){
            stock1.makeTwoForOne(products[j].getClass());
        }

        for(int j=0; j<3; j++){
            Class prodClass = products[j].getClass();
            assertEquals(true, stock1.isTwoForOne(prodClass));
        }

        for(int j=0; j<3; j++){
            stock1.removeFromTwoForOne(products[j].getClass());
        }

        for(int j=0; j<3; j++){
            Class prodClass = products[j].getClass();
            assertEquals(false, stock1.isTwoForOne(prodClass));
        }
    }
}