package shop_test;

import org.junit.Before;
import org.junit.Test;
import shop.Shop;

import java.math.BigDecimal;

import static junit.framework.TestCase.assertEquals;

public class ShopTest {

    private Shop shop1;
    private static String INITAL_SHOP_NAME = "The Big Shop";
    private static double INITAL_SHOP_MONEY = 500;

    @Before
    public void setup(){
        shop1 = new Shop(INITAL_SHOP_NAME, INITAL_SHOP_MONEY);
    }

    @Test
    public void canGetName(){
        String expected1 = INITAL_SHOP_NAME;
        String result1 = shop1.getName();
        assertEquals(expected1, result1);
    }

    @Test
    public void canGetMoney(){
        double expected1 = INITAL_SHOP_MONEY;
        double result1 = shop1.getMoney();
        assertEquals(expected1, result1);
    }
}