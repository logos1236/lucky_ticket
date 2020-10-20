package ru.armishev;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestTicket {
    /*
    Создается билет
     */
    @Test
    public void ticketTest() {
        Ticket test = new Ticket(6, 6);
        assertNotNull(test);
    }

    /*
     * Созданный билет реализует интерфейс Lucky
     */

    @Test
    public void isTicketLuckyTest() {
        try {
            Lucky test = new Ticket(6, 6);
        } catch (ClassCastException e) {
            assertFalse(true);
        }
    }


    /*
    Проверка ошибок при отрицательных значениях,
    передываемых в конструктор для создания билета
     */
    @Test
    public void ticketConstructorNegativeNumberTest() {
        try {
            Ticket test = new Ticket(-6, 6);
            Ticket test2 = new Ticket(6, -6);
            assertFalse(true);
        } catch (RuntimeException e) {
            assertEquals(e.getClass(), IllegalArgumentException.class);
            assertNotEquals(e.getMessage(),"");
        }
    }

    /*
    Проверка ошибок при отрицательных значениях,
    передываемых в метод приведения номера билета к массиву
     */
    @Test
    public void supplementedTicketNumberNegativeTest() {
        try {
            Ticket.getSupplementedTicketNumber(-6, 6);
            Ticket.getSupplementedTicketNumber(6, -6);
            assertFalse(true);
        } catch (RuntimeException e) {
            assertEquals(e.getClass(), IllegalArgumentException.class);
            assertNotEquals(e.getMessage(),"");
        }
    }

    /*
    Проверка метода приведения номера билета к массиву
     */
    @Test
    public void supplementedTicketNumberNullTest() {
        int[] number = Ticket.getSupplementedTicketNumber(123,6);

        assertNotNull(number);
    }

    /*
    Проверка метода приведения номера билета к массиву
     */
    @Test
    public void supplementedTicketNumberLengthTest() {
        int count_numbers = 6;
        int[] number = Ticket.getSupplementedTicketNumber(123,count_numbers);

        assertEquals(number.length, count_numbers);
    }

    /*
    Проверка счастливого билета
     */
    @Test
    public void isLuckyTest() {
        Ticket test = new Ticket(1001, 6);
        assertTrue(test.isLucky());
    }

    @Test
    public void isLuckyNegativeTest() {
        Ticket test = new Ticket(1, 6);
        assertFalse(test.isLucky());
    }

    /*
    Проверка счастливого четного билета
     */
    @Test
    public void isLuckyEvenTest() {
        Ticket test = new Ticket(2002, 6);
        assertTrue(test.isEvenLucky());
    }

    @Test
    public void isLuckyEvenNegativeTest() {
        Ticket test = new Ticket(3003, 6);
        assertFalse(test.isEvenLucky());
    }

    /*
    Проверка счастливого билета, делящегося на 3
     */
    @Test
    public void isLuckyThirdTest() {
        Ticket test = new Ticket(3003, 6);
        assertTrue(test.isThirdLucky());
    }

    @Test
    public void isLuckyThirdNegativeTest() {
        Ticket test = new Ticket(4004, 6);
        assertFalse(test.isThirdLucky());
    }

    /*
    Проверка приведения к строке
     */
    @Test
    public void toStringTest() {
        Ticket test = new Ticket(3003, 6);
        assertNotNull(test.toString());
    }

    /*
    Проверка хеширования
     */
    @Test
    public void hashCodeTest() {
        Ticket test = new Ticket(3003, 6);
        Ticket test2 = new Ticket(3003, 6);

        assertEquals(test.hashCode(), test2.hashCode());
    }

    @Test
    public void hashCodeNegativeTest() {
        Ticket test = new Ticket(3003, 6);
        Ticket test2 = new Ticket(3000, 6);

        assertNotEquals(test.hashCode(), test2.hashCode());
    }

}
