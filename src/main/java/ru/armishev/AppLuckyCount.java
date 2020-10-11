package ru.armishev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.function.Predicate;
import java.util.function.Supplier;

@Service("AppLuckyCount")
public class AppLuckyCount implements Supplier<Long> {
    @Autowired
    @Qualifier("Generator")
    Iterator<Lucky> iterator;

    @Autowired
    @Qualifier("LuckyMethod")
    Predicate<Lucky> method;

    @Override
    public Long get() {
        long count_luck_tickets = 0;

        while (iterator.hasNext()) {
            Lucky t = iterator.next();
            if (method.test(t)) {
                System.out.println(t);
                count_luck_tickets++;
            }
        }

        return count_luck_tickets;
    }
}
