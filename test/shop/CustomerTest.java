package shop;

import Products.Crisps;
import Products.Pizza;
import Products.ToothPaste;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static junit.framework.TestCase.assertEquals;

public class CustomerTest {

    private Shop shop1;
    private Customer customer1;

    @Before
    public void setup(){
        shop1 = new Shop("The Shop", 1000);
        Stock stock = shop1.getStock();
        stock.add(new Pizza());
        stock.add(new Crisps());
        stock.add(new Crisps());
        stock.add(new ToothPaste());
        stock.add(new Pizza());
        stock.add(new ToothPaste());

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

    @Test
    public void canAddItemToBasket(){
        customer1.enterShop(shop1);

        assertEquals(0, customer1.countBasketItems());

        customer1.addToBasket(0);
        customer1.addToBasket(0);
        customer1.addToBasket(0);

        assertEquals(3, customer1.countBasketItems());
    }

    @Test
    public void canRemoveItemFromBasket(){
        customer1.enterShop(shop1);

        customer1.addToBasket(0);
        customer1.addToBasket(0);
        customer1.addToBasket(0);

        customer1.removeFromBasket(0);
        customer1.removeFromBasket(0);
        customer1.removeFromBasket(0);

        assertEquals(0, customer1.countBasketItems());
    }

    @Test (expected = IllegalStateException.class)
    public void cannotUseBasketWhenNotInShop__CountItems(){
        customer1.countBasketItems();
    }
    @Test (expected = IllegalStateException.class)
    public void cannotUseBasketWhenNotInShop__AddItems(){
        customer1.addToBasket(0);
    }
    @Test (expected = IllegalStateException.class)
    public void cannotUseBasketWhenNotInShop__RemoveItems(){
        customer1.removeFromBasket(0);
    }
}