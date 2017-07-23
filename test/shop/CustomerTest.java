package shop;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static junit.framework.TestCase.assertEquals;

public class CustomerTest {

    private Shop shop1
    private Customer customer1;

    @Before
    public void setup(){
        shop1 = new Shop("The Shop", 1000);
        customer1 = new Customer(200.00, true);
    }

    @Test
    public void canGetMoney(){
        assertEquals(200.00, customer1.getMoney());
    }

    @Test
    public void canGetMoneyAsBigDecimal(){
        BigDecimal money = customer1.getMoneyAsBigDecimal();
        assertEquals(200.00, money.doubleValue());
    }

    @Test
    public void canIncreaseMoney(){
        double amount = 100;
        customer1.increaseMoney(amount);
        assertEquals(300.00, customer1.getMoney());
    }

    @Test
    public void canDecreaseMoney(){
        double amount = 100;
        customer1.decreaseMoney(amount);
        assertEquals(100.00, customer1.getMoney());
    }

    @Test
    public void customerCanEnterShop(){
        customer1.enterShop(shop1);
        assertEquals(true, shop1.isCustomerInShop(customer1));
    }
}