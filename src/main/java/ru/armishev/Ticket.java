package ru.armishev;

import java.util.Arrays;

public class Ticket implements Lucky {
    private final int[] number;

    public Ticket(int[] number) {
        this.number = number;
    }

    public Ticket(long number, int countNumbers) {
        if (number < 0) {
            throw new IllegalArgumentException("Передано отрицательное число в качестве номера");
        }

        if (countNumbers < 2) {
            throw new IllegalArgumentException("Передано неправильное число в качестве количества цифр в билете");
        }

        this.number = getSupplementedTicketNumber(number, countNumbers);
    }

    public static int[] getSupplementedTicketNumber(long number, int countNumbers) {
        if (number < 0) {
            throw new IllegalArgumentException("Передано отрицательное число в качестве номера");
        }

        if (countNumbers < 2) {
            throw new IllegalArgumentException("Передано неправильное число в качестве количества цифр в билете");
        }

        char[] numberArr = String.valueOf(number).toCharArray();
        int[] result = new int[countNumbers];
        int fillStartIndex = countNumbers - numberArr.length;

        for (int i = 0; i < numberArr.length; i++) {
            result[fillStartIndex+i] = Character.getNumericValue(numberArr[i]);
        }

        return result;
    }

    @SuppressWarnings("IntegerDivisionInFloatingPointContext")
    @Override
    public boolean isLucky() {
        int rightSum = 0;
        int leftSum = 0;
        int middleNumberTicket;

        if (number.length%2==0) {
            middleNumberTicket = number.length/2-1;
        } else {
            middleNumberTicket = (number.length+1)/2;
        }

        for(int i = 0; i <= middleNumberTicket; i++) {
            leftSum += number[i];
            rightSum += number[1+middleNumberTicket+i];
        }

        return leftSum == rightSum;
    }

    @Override
    public boolean isEvenLucky() {
        return this.isLucky() && (this.number[this.number.length - 1] % 2 == 0);
    }

    @Override
    public boolean isThirdLucky() {
        int sumDigitsInNumber = Arrays.stream(this.number).sum();

        return this.isLucky() && (sumDigitsInNumber % 3 == 0);
    }

    @Override
    public String toString() {
        return Arrays.toString(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Arrays.equals(number, ticket.number);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(number);
    }
}
