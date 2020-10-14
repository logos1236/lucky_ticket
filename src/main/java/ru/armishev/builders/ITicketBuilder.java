package ru.armishev.builders;

import ru.armishev.Ticket;

public interface ITicketBuilder {
    public Ticket build();

    public ITicketBuilder setTicketInfo(long number, int count_numbers);

}
