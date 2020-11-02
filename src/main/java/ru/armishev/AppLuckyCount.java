package ru.armishev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.function.LongSupplier;
import java.util.function.Predicate;

@Service("AppLuckyCount")
public class AppLuckyCount implements LongSupplier {
    @Autowired
    @Qualifier("Generator")
    Iterator<Lucky> iterator;

    @Autowired
    @Qualifier("LuckyMethod")
    Predicate<Lucky> method;

    @Override
    public long getAsLong() {
        long countLuckTickets = 0;

        while (iterator.hasNext()) {
            Lucky t = iterator.next();
            if (method.test(t)) {
                System.out.println(t);
                countLuckTickets++;
            }
        }

        return countLuckTickets;
    }
}
