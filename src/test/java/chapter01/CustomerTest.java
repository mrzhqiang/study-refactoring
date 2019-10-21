package chapter01;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CustomerTest {

    private Customer customer;

    @Before
    public void setUp() throws Exception {
        customer = new Customer("test 1");
    }

    @Test
    public void statement() {
        Assert.assertEquals(customer.statement(), "Rental record for test 1\n" +
                "Amount owed is 0.0\n" +
                "You earned 0 frequent renter points");
    }
}