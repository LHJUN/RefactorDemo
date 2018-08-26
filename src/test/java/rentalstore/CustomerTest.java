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
        String expectedResult = "<H1>Rental Record for <EM>customer</EM></H1>\n" +
                "CHILDRENS_movie: 1.5<BR>\n" +
                "REGULAR_movie: 3.5<BR>\n" +
                "NEW_RELEASE_movie: 6.0<BR>\n" +
                "<P>You owe<EM>11.0</EM></P>\n" +
                "On this rental you earned <EM>4</EM> frequent renter points<P>";
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
        System.out.println(result);
        // then
        Assert.assertEquals(expectedResult, result);

    }

    @Test
    public void should_return_statement_when_rental_given_customer_rental_movies_exceed_timelimit() {
        // given
        String expectedResult = "<H1>Rental Record for <EM>customer</EM></H1>\n" +
                "CHILDRENS_movie: 1.5<BR>\n" +
                "REGULAR_movie: 5.0<BR>\n" +
                "NEW_RELEASE_movie: 9.0<BR>\n" +
                "<P>You owe<EM>15.5</EM></P>\n" +
                "On this rental you earned <EM>4</EM> frequent renter points<P>";
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
        System.out.println(result);
        // then
        Assert.assertEquals(expectedResult, result);
    }
}
