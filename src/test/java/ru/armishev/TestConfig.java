package ru.armishev;

import org.junit.Test;

import java.util.function.Predicate;

import static org.junit.Assert.*;

public class TestConfig {
    @Test
    public void getCountDigitsInTicketTest() {
        assertTrue(AppConfig.getCountDigitsInTicket()>2);
    }

    @Test
    public void getLuckyMethodTest() {
        assertNotNull(AppConfig.getLuckyMethod());
    }

    @Test
    public void getLuckyMethodСlassTest() {
        boolean result = false;
        if (AppConfig.getLuckyMethod() instanceof Predicate) {
            result = true;
        }

        assertTrue(result);
    }
}
