package chapter01;

import java.util.Enumeration;
import java.util.Vector;

class Customer {
    private String name;
    private Vector<Rental> rentals = new Vector<>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addRental(Rental rental) {
        this.rentals.addElement(rental);
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoint = 0;
        Enumeration<Rental> rentals = this.rentals.elements();
        String result = "Rental record for " + getName() + "\n";
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();

            frequentRenterPoint ++;

            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
                    each.getDaysRented() > 1) {
                frequentRenterPoint++;
            }

            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
            totalAmount += each.getCharge();
        }

        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoint) + " frequent renter points";
        return result;
    }
}
