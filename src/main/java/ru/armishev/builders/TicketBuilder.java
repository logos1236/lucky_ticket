package ru.armishev.builders;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.armishev.Ticket;

@Service("TicketBuilder")
@Scope("prototype")
public class TicketBuilder implements ITicketBuilder {
    private int[] ticket_number;

    /*
    Признак того, что билет уже использовался
    */
    private Boolean is_used = false;

    @Override
    public Ticket build() {
        if (is_used) {
            throw new IllegalArgumentException("Билет уже использовался");
        }

        is_used = true;
        return new Ticket(ticket_number);
    }

    @Override
    public TicketBuilder setTicketInfo(long number, int count_numbers) {
        this.ticket_number = Ticket.getSupplementedTicketNumber(number, count_numbers);
        return this;
    }
}
