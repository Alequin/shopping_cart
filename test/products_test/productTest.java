package products_test;

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

}
