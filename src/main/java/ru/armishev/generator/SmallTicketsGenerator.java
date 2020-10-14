package ru.armishev.generator;

import ru.armishev.Lucky;
import ru.armishev.Ticket;

import java.util.Iterator;

@Deprecated
public class SmallTicketsGenerator implements Iterator<Lucky> {
    private final int MAX_COUNT = 10000;
    private int current = 0;

    @Override
    public boolean hasNext() {
        return (current < MAX_COUNT);
    }

    @Override
    public Lucky next() {
        Lucky result = new Ticket(current, 4);
        current++;

        return result;
    }
}
