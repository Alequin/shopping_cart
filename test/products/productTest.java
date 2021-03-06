package products;

import Products.Crisps;
import Products.Pizza;
import Products.Product;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static junit.framework.TestCase.assertEquals;

public class productTest {

    Product product1;

    @Before
    public void setup(){
        product1 = new Pizza();
    }

    @Test
    public void canGetName(){
        String expected = "Pizza";
        String result = product1.getName();
        assertEquals(expected, result);
    }

    @Test
    public void canGetCost(){
        double expected = 6.50;
        double result = product1.getCost();
        assertEquals(expected, result);
    }

    @Test
    public void canGetCostAsBigDecimal(){
        double expected = 6.50;
        BigDecimal result = product1.getCostAsBigDecimal();
        assertEquals(expected, result.doubleValue());
    }

    @Test
    public void canSetCost(){
        double expected1 = 6.50;
        product1.setCost(expected1);
        double result1 = product1.getCost();
        assertEquals(expected1, result1);

        double expected2 = 0;
        product1.setCost(expected2);
        double result2 = product1.getCost();
        assertEquals(expected2, result2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotSetCostUnderZero(){
        product1.setCost(-0.01);
    }

    @Test
    public void canGetSubClass(){
        Class expected1 = Pizza.class;
        Class result1 = product1.getClass();
        assertEquals(expected1, result1);

        Product product2 = new Crisps();

        Class expected2 = Crisps.class;
        Class result2 = product2.getClass();
        assertEquals(expected2, result2);
    }
}
