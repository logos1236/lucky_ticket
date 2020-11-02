package ru.armishev;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.function.Supplier;

public class Main {
    @SuppressWarnings("rawtypes")
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("ru.armishev");
        Supplier lucky_count = context.getBean("AppLuckyCount", Supplier.class);

        System.out.println(lucky_count.get());
    }
}
