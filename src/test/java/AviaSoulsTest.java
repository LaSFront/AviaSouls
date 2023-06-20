import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class AviaSoulsTest {

    @Test
    public void shouldCompareToPriceOfTwoTickets() {
        Ticket ticket1 = new Ticket(
                "Мoсква",
                "Саратов",
                5_500,
                21,
                23
        );

        Ticket ticket2 = new Ticket(
                "Москва",
                "Сочи",
                7_800,
                12,
                16
        );

        int expected = -1;
        int actual = ticket1.compareTo(ticket2);
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void shouldCompareToPriceOfTwoTickets2() {
        Ticket ticket1 = new Ticket(
                "Мoсква",
                "Саратов",
                15_500,
                21,
                23
        );

        Ticket ticket2 = new Ticket(
                "Москва",
                "Сочи",
                7_800,
                12,
                16
        );

        int expected = 1;
        int actual = ticket1.compareTo(ticket2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareToPriceOfTwoTickets3() {
        Ticket ticket1 = new Ticket(
                "Мoсква",
                "Саратов",
                5_500,
                21,
                23
        );

        Ticket ticket2 = new Ticket(
                "Москва",
                "Сочи",
                5_500,
                12,
                16
        );

        int expected = 0;
        int actual = ticket1.compareTo(ticket2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSortSomeTicketsByPrice_CompareTo() {

        Ticket ticket1 = new Ticket(
                "Мoсква",
                "Саратов",
                5_500,
                21,
                23
        );

        Ticket ticket2 = new Ticket(
                "Москва",
                "Сочи",
                1_800,
                12,
                16
        );

        Ticket ticket3 = new Ticket(
                "Москва",
                "Сочи",
                2_800,
                12,
                16
        );

        Ticket[] expected = {ticket2, ticket3, ticket1};
        Ticket[] actual = {ticket1, ticket2, ticket3};
        Arrays.sort(actual);
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldSortSomeTicketsByFlightTime_Comporator() {
        TicketTimeComparator flightTimeComparator = new TicketTimeComparator();

        Ticket ticket1 = new Ticket(
                "Мoсква",
                "Саратов",
                5_500,
                20,
                23
        );

        Ticket ticket2 = new Ticket(
                "Москва",
                "Сочи",
                7_800,
                12,
                16
        );

        Ticket ticket3 = new Ticket(
                "Москва",
                "Владимир",
                6_500,
                14,
                16
        );

        Ticket[] expected = {ticket3, ticket1, ticket2};
        Ticket[] actual = {ticket1, ticket2, ticket3};
        Arrays.sort(actual, flightTimeComparator);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortByPriceAfterSearch() {

        AviaSouls repo = new AviaSouls();

        repo.add(new Ticket("Москва", "Сочи", 7_800, 12, 16));
        repo.add(new Ticket("Москва", "Сочи", 5_600, 14, 18));
        repo.add(new Ticket("Москва", "Сочи", 4_200, 9, 14));
        repo.add(new Ticket("Москва", "Самара", 4_400, 18, 22));


        Ticket[] expected = {
                new Ticket("Москва", "Сочи", 4_200, 9, 14),
                new Ticket("Москва", "Сочи", 5_600, 14, 18),
                new Ticket("Москва", "Сочи", 7_800, 12, 16)
        };
        Ticket[] actual = repo.search("Москва", "Сочи");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSortByParametersFromComparator() {

        AviaSouls repo = new AviaSouls();
        TicketTimeComparator sortBy = new TicketTimeComparator();

        repo.add(new Ticket("Москва", "Сочи", 7_800, 12, 16));
        repo.add(new Ticket("Москва", "Самара", 5_600, 14, 16));
        repo.add(new Ticket("Москва", "Сочи", 4_200, 9, 14));
        repo.add(new Ticket("Москва", "Самара", 4_400, 19, 22));

        Ticket[] expected = {
                new Ticket("Москва", "Самара", 5_600, 14, 16),
                new Ticket("Москва", "Самара", 4_400, 19, 22),

        };

        Ticket[] actual = repo.searchAndSortBy("Москва", "Самара", sortBy);
        Assertions.assertArrayEquals(expected, actual);

    }


}
