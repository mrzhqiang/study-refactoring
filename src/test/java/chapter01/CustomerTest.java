package chapter01;

import org.junit.Assert;
import org.junit.Test;

public class CustomerTest {

    @Test
    public void normal() {
        Customer customer = new Customer("test 1");
        Assert.assertEquals("Rental record for test 1\n" +
                        "Amount owed is 0.0\n" +
                        "You earned 0 frequent renter points",
                customer.statement());
    }

    @Test
    public void other() {
        Customer customer = new Customer("test 2");
        customer.addRental(new Rental(new Movie("book 1", Movie.NEW_RELEASE), 10));
        customer.addRental(new Rental(new Movie("book 2", Movie.REGULAR), 5));
        customer.addRental(new Rental(new Movie("book 3", Movie.CHILDRENS), 3));
        Assert.assertEquals("Rental record for test 2\n" +
                        "\tbook 1\t30.0\n" +
                        "\tbook 2\t6.5\n" +
                        "\tbook 3\t1.5\n" +
                        "Amount owed is 38.0\n" +
                        "You earned 4 frequent renter points",
                customer.statement());
    }
}