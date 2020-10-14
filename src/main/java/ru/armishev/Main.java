package ru.armishev;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("ru.armishev");
        Supplier lucky_count = context.getBean("AppLuckyCount", Supplier.class);

        System.out.println(lucky_count.get());
    }
}
