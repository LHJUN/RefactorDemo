package rentalstore;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String name;
    private Vector rentals = new Vector();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.addElement(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rentals = this.rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            //show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }

        //add footer lines
        result += "Amount owed is" + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned" + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int points = 0;
        Enumeration rentalss = rentals.elements();
        while(rentalss.hasMoreElements())
        {
            Rental each = (Rental) rentalss.nextElement();
            points += each.getFrequentRenterPoints();
        }
        return points;
    }

    private double getTotalCharge()
    {
        double result = 0;
        Enumeration rentalss = rentals.elements();
        while(rentalss.hasMoreElements())
        {
            Rental each = (Rental) rentalss.nextElement();
            result += each.getCharge();
        }
        return result;
    }
}
