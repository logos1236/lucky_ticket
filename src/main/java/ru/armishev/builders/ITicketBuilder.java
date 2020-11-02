package ru.armishev.builders;

import ru.armishev.Ticket;

public interface ITicketBuilder {
    Ticket build();

    ITicketBuilder setTicketInfo(long number, int count_numbers);

}
