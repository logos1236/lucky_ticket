package ru.armishev;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.armishev.generator.CustomizableTicketsGenerator;
import static org.junit.Assert.*;

public class TestTicketsGenerator {
    private static AnnotationConfigApplicationContext context;

    @BeforeClass
    public static void preInit() {
        context = new AnnotationConfigApplicationContext("ru.armishev");
    }

    /*
    Создание объекта генератора
    */
    @Test
    public void initGeneratorTest() {
        CustomizableTicketsGenerator g = new CustomizableTicketsGenerator(6);
        assertNotNull(g);
    }

    @Test
    public void initNegativeGeneratorTest() {
        try {
            new CustomizableTicketsGenerator(-6);
            fail();
        } catch (Exception e) {
            assertEquals(e.getClass(), IllegalArgumentException.class);
            assertNotEquals(e.getMessage(),"");
        }
    }

    /*
    Корректность hasNext
    */
    @Test
    public void hasNextTest() {
        int count_digits = 2;
        CustomizableTicketsGenerator g = new CustomizableTicketsGenerator(count_digits);
        g.setApplicationContext(context);

        assertTrue(g.hasNext());

        int max_i = (int)Math.pow(10, count_digits);
        for(int i=0; i < max_i; i++) {
            g.next();
        }

        assertFalse(g.hasNext());
    }

    /*
    Правильность создания определенного количества билетов
     */
    @Test
    public void countElemTest() {
        int count_digits = 2;
        CustomizableTicketsGenerator g = new CustomizableTicketsGenerator(count_digits);
        g.setApplicationContext(context);

        int i = 0;
        while (g.hasNext()) {
            g.next();
            i++;
        }

        assertEquals((int)Math.pow(10, count_digits), i);
    }

}
