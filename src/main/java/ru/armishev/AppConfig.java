package ru.armishev;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Predicate;

@Configuration
public class AppConfig {
    @Bean("CountNumbersInTicket")
    public static Integer getCountNumbersInTicket() {
        return 6;
    }

    @Bean("LuckyMethod")
    public static Predicate<Lucky> getLuckyMethod() {
        Predicate<Lucky> method = (ticket) -> {
            return ticket.isLucky();
        };

        return method;
    }
}
