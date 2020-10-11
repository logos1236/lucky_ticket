package ru.armishev.generator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.armishev.Lucky;
import ru.armishev.Ticket;

import java.util.Iterator;

@Service("Generator")
public class CustomizableTicketsGenerator implements Iterator<Lucky> {
    private int MAX_COUNT;
    private int count_numbers;
    private int current = 0;

    @Autowired
    public CustomizableTicketsGenerator(@Qualifier("CountNumbers")int count_numbers) {
        this.count_numbers = count_numbers;
        this.MAX_COUNT = (int)Math.pow(10,count_numbers);
    }

    @Override
    public boolean hasNext() {
        return (current < MAX_COUNT);
    }

    @Override
    public Lucky next() {
        Lucky result = new Ticket(Ticket.getSupplementedTicketNumber(current, count_numbers));
        current++;

        return result;
    }
}
