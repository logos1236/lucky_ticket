package ru.armishev.generator;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import ru.armishev.Lucky;
import ru.armishev.builders.TicketBuilder;

import java.util.Iterator;
import java.util.NoSuchElementException;

@Service("Generator")
public class CustomizableTicketsGenerator implements Iterator<Lucky>, ApplicationContextAware {
    private final int MAX_COUNT;
    private final int countNumbers;
    private int current = 0;

    private ApplicationContext context;

    @Autowired
    public CustomizableTicketsGenerator(@Qualifier("CountDigitsInTicket")int countDigits) {
        if (countDigits < 2) {
            throw new IllegalArgumentException("Нужны минимум 2 цифры");
        }

        this.countNumbers = countDigits;
        this.MAX_COUNT = (int)Math.pow(10,countDigits);
    }

    @Override
    public boolean hasNext() {
        return (current < MAX_COUNT);
    }

    @Override
    public Lucky next() {
        if (current >= MAX_COUNT) {
            throw new NoSuchElementException("Нет такого элемента");
        }

        Lucky result = context.getBean("TicketBuilder", TicketBuilder.class).setTicketInfo(current, countNumbers).build();
        current++;

        return result;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}
