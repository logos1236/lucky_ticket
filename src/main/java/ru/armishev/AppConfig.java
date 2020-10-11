package ru.armishev;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Predicate;

@Configuration
public class AppConfig {
    @Bean("CountNumbers")
    public static Integer getCountNumbers() {
        return 4;
    }

    @Bean("LuckyMethod")
    public static Predicate<Lucky> getLuckyCount() {
        Predicate<Lucky> method = (ticket) -> {
            return ticket.isLucky();
        };

        return method;
    }
}
