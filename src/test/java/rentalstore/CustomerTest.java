package rentalstore;

import org.junit.Assert;
import org.junit.Test;

/**
 * @ Author     ：LILA3
 * @ Date       ：Created in 10:39 PM 8/26/2018
 */
public class CustomerTest {
    @Test
    public void should_return_statement_when_rental_given_customer_rental_movies_do_not_exceed_timelimit() {
        // given
        String expectedResult = "Rental Record for customer\n" +
                "\tCHILDRENS_movie\t1.5\n" +
                "\tREGULAR_movie\t3.5\n" +
                "\tNEW_RELEASE_movie\t6.0\n" +
                "Amount owed is11.0\n" +
                "You earned4 frequent renter points";
        Customer customer = new Customer("customer");
        Movie childrensMovie = new Movie("CHILDRENS_movie", 2);
        Movie regularMovie = new Movie("REGULAR_movie", 0);
        Movie newReleaseMovie = new Movie("NEW_RELEASE_movie", 1);
        Rental cRental = new Rental(childrensMovie, 2);
        Rental rRental = new Rental(regularMovie, 3);
        Rental nRental = new Rental(newReleaseMovie, 2);
        customer.addRental(cRental);
        customer.addRental(rRental);
        customer.addRental(nRental);

        // when
        String result = customer.statement();

        // then
        Assert.assertEquals(expectedResult, result);

    }

    @Test
    public void should_return_statement_when_rental_given_customer_rental_movies_exceed_timelimit() {
        // given
        String expectedResult = "Rental Record for customer\n" +
                "\tCHILDRENS_movie\t1.5\n" +
                "\tREGULAR_movie\t5.0\n" +
                "\tNEW_RELEASE_movie\t9.0\n" +
                "Amount owed is15.5\n" +
                "You earned4 frequent renter points";
        Customer customer = new Customer("customer");
        Movie childrensMovie = new Movie("CHILDRENS_movie", 2);
        Movie regularMovie = new Movie("REGULAR_movie", 0);
        Movie newReleaseMovie = new Movie("NEW_RELEASE_movie", 1);
        Rental cRental = new Rental(childrensMovie, 3);
        Rental rRental = new Rental(regularMovie, 4);
        Rental nRental = new Rental(newReleaseMovie, 3);
        customer.addRental(cRental);
        customer.addRental(rRental);
        customer.addRental(nRental);

        // when
        String result = customer.statement();

        // then
        Assert.assertEquals(expectedResult, result);
    }
}
