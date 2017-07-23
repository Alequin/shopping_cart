package shop_test;

import org.junit.Before;
import shop.Basket;
import shop.Shop;


public class BasketTest {

    private Shop shop1;
    private Basket basket1;

    @Before
    public void setup(){
        shop1 = new Shop("The Shop", 500);
        basket1 = shop1.makeBasket();
    }

}