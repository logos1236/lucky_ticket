package ru.armishev;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.function.LongSupplier;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("ru.armishev");
        LongSupplier luckyCount = context.getBean("AppLuckyCount", LongSupplier.class);

        System.out.println(luckyCount.getAsLong());
    }
}
