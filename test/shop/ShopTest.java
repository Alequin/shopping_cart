package shop;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static junit.framework.TestCase.assertEquals;

public class ShopTest {

    private Shop shop1;
    private static String INITIAL_SHOP_NAME = "The Big Shop";
    private static double INITIAL_SHOP_MONEY = 500;

    @Before
    public void setup(){
        shop1 = new Shop(INITIAL_SHOP_NAME, INITIAL_SHOP_MONEY);
    }

    @Test
    public void canGetName(){
        String expected1 = INITIAL_SHOP_NAME;
        String result1 = shop1.getName();
        assertEquals(expected1, result1);
    }

    @Test
    public void canGetMoney(){
        double expected1 = INITIAL_SHOP_MONEY;
        double result1 = shop1.getMoney();
        assertEquals(expected1, result1);
    }

    @Test
    public void canSetMoneyToZero(){
        double expected1 = 0;
        Shop shop = new Shop("x shop", 0);
        double result1 = shop.getMoney();
        assertEquals(expected1, result1);
    }

    @Test
    public void canIncreaseMoney(){
        BigDecimal initialMoney = BigDecimal.valueOf(shop1.getMoney());
        double toAdd = 250.50;
        BigDecimal expected1 = initialMoney.add(BigDecimal.valueOf(250.50));

        shop1.increaseMoney(toAdd);
        double result1 = shop1.getMoney();

        assertEquals(expected1.doubleValue(), result1);
    }

    @Test
    public void canDecreaseMoney(){
        BigDecimal initialMoney = BigDecimal.valueOf(shop1.getMoney());
        double toSubtract = 250.50;
        BigDecimal expected1 = initialMoney.subtract(BigDecimal.valueOf(250.50));

        shop1.decreaseMoney(toSubtract);
        double result1 = shop1.getMoney();

        assertEquals(expected1.doubleValue(), result1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotSetInitialMoneyLessThanZero(){
        new Shop("x shop", -0.1);
    }

    @Test
    public void canAddCustomer(){

        assertEquals(0, shop1.getCustomerCount());

        Customer c1 = new Customer(200, false);
        shop1.addCustomer(c1);

        assertEquals(1, shop1.getCustomerCount());
        assertEquals(c1, shop1.getCustomers()[0]);
    }
}
