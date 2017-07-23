package shop_test;

import org.junit.Before;
import org.junit.Test;
import shop.Shop;

import static junit.framework.TestCase.assertEquals;

public class productTest {

    private Shop shop1;

    @Before
    public void setup(){
        shop1 = new Shop("The Big Shop");
    }

    @Test
    public void canGetName(){
        String expected1 = "The Big Shop";
        String result1 = shop1.getName();
        assertEquals(expected1, result1);
    }


}
