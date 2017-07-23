package shop;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CustomerTest {

    private Customer customer;

    @Test
    public void setup(){
        customer = new Customer(200.00, true);
    }

}