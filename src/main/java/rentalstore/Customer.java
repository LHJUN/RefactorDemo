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
        Enumeration rentals = this.rentals.elements();
        String result = "<H1>Rental Record for <EM>" + getName() + "</EM></H1>\n";
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            //show figures for this rental
            result += each.getMovie().getTitle() + ": " + String.valueOf(each.getCharge()) + "<BR>\n";
        }

        //add footer lines
        result += "<P>You owe<EM>" + String.valueOf(getTotalCharge()) + "</EM></P>\n";
        result += "On this rental you earned <EM>" + String.valueOf(getTotalFrequentRenterPoints()) + "</EM> frequent renter points<P>";
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
