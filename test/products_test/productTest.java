package products_test;

import Products.Crisps;
import Products.Pizza;
import Products.Product;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class productTest {

    Product product1;

    @Before
    public void setup(){
        product1 = new Pizza(4.23);
    }

    @Test
    public void canGetName(){
        String expected = "Pizza";
        String result = product1.getName();
        assertEquals(expected, result);
    }

    @Test
    public void canGetPrice(){
        double expected = 4.23;
        double result = product1.getCost();
        assertEquals(expected, result);
    }

    @Test
    public void canSetPrice(){
        double expected = 6.50;
        product1.setCost(expected);
        double result = product1.getCost();
        assertEquals(expected, result);
    }

    @Test
    public void canGetSubClass(){
        Class expected1 = Pizza.class;
        Class result1 = product1.getClass();
        assertEquals(expected1, result1);

        Product product2 = new Crisps(2.25);
        
        Class expected2 = Pizza.class;
        Class result2 = product1.getClass();
        assertEquals(expected2, result2);
    }

}
