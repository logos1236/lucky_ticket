package ru.armishev;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Predicate;

@Configuration
public class AppConfig {
    @SuppressWarnings({"SameReturnValue", "unused"})
    @Bean("CountDigitsInTicket")
    public static Integer getCountDigitsInTicket() {
        return 6;
    }

    @SuppressWarnings({"unused", "Convert2MethodRef", "CodeBlock2Expr"})
    @Bean("LuckyMethod")
    public static Predicate<Lucky> getLuckyMethod() {
        return (ticket) -> {
            return ticket.isThirdLucky();
        };
    }
}
