package ru.armishev;

import org.junit.Test;
import ru.armishev.builders.TicketBuilder;

import static org.junit.Assert.*;

public class TestBuilder {
    @Test
    public void createTicketBuilderTest() {
        int number = 6;
        int count_numbers = 6;

        TicketBuilder tb = new TicketBuilder();
        tb.setTicketInfo(number,count_numbers);
        Ticket t1= tb.build();

        assertNotNull(t1);
    }

    @Test
    public void buildExpectTicketTest() {
        int number = 6;
        int count_numbers = 6;

        TicketBuilder tb = new TicketBuilder();
        tb.setTicketInfo(number,count_numbers);
        Ticket t1= tb.build();

        Ticket t2 = new Ticket(number,count_numbers);

        assertEquals(t1,t2);
    }

    @Test
    public void createTicketBuilderNegativeTest() {
        try {
            int number = 6;
            int count_numbers = -6;

            TicketBuilder tb = new TicketBuilder();
            tb.setTicketInfo(number,count_numbers);
            tb.build();

            fail();
        } catch (RuntimeException e) {
            assertEquals(e.getClass(), IllegalArgumentException.class);
            assertNotEquals(e.getMessage(),"");
        }
    }

    /*
    Повторное использование лбъекта билдера
     */
    @Test
    public void reuseTicketBuilder() {
        int number = 6;
        int count_numbers = 6;

        TicketBuilder tb = new TicketBuilder();
        tb.setTicketInfo(number,count_numbers);

        try {
            tb.build();
            tb.build();

            fail();
        } catch (Exception e) {
            assertEquals(e.getClass(), IllegalArgumentException.class);
            assertNotEquals(e.getMessage(),"");
        }
    }
}
