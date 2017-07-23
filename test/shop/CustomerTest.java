package shop;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static junit.framework.TestCase.assertEquals;

public class CustomerTest {

    private Customer customer;

    @Before
    public void setup(){
        customer = new Customer(200.00, true);
    }

    @Test
    public void canGetMoney(){
        assertEquals(200.00, customer.getMoney());
    }

    @Test
    public void canGetMoneyAsBigDecimal(){
        BigDecimal money = customer.getMoneyAsBigDecimal();
        assertEquals(200.00, money.doubleValue());
    }

    @Test
    public void canIncreaseMoney(){
        double amount = 100;
        customer.increaseMoney(amount);
        assertEquals(300.00, customer.getMoney());
    }

    @Test
    public void canDecreaseMoney(){
        double amount = 100;
        customer.decreaseMoney(amount);
        assertEquals(100.00, customer.getMoney());
    }
}