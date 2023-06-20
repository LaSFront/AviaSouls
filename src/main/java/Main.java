import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Ticket ticket1 = new Ticket(
                "Мoсква",
                "Сочи",
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
                "Сочи",
                5_500,
                14,
                16
        );

        System.out.println(ticket1.compareTo(ticket2));
        System.out.println(ticket2.compareTo(ticket1));
        System.out.println(ticket1.compareTo(ticket3));

        TicketTimeComparator flightTimeComparator = new TicketTimeComparator();

        Ticket[] tickets = {ticket1, ticket2, ticket3};
        Arrays.sort(tickets);
        Arrays.sort(tickets, flightTimeComparator);

    }
}

