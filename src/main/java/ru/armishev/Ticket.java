package ru.armishev;

import java.util.Arrays;

public class Ticket implements Lucky {
    private int[] number;

    public Ticket(int[] number) {
        this.number = number;
    }

    public static int[] getSupplementedTicketNumber(long number, int count_numbers) {
        char[] number_arr = String.valueOf(number).toCharArray();
        int[] result = new int[count_numbers];
        int fill_start_index = count_numbers - number_arr.length;

        for (int i = 0; i < number_arr.length; i++) {
            result[fill_start_index+i] = Character.getNumericValue(number_arr[i]);
        }

        return result;
    }

    @Override
    public boolean isLucky() {
        int right_summ = 0;
        int left_summ = 0;
        int middle_number_ticket = 0;

        if (number.length%2==0) {
            middle_number_ticket = (int)Math.ceil(number.length/2)-1;
        } else {
            middle_number_ticket = (int)Math.ceil(number.length/2);
        }

        for(int i = 0; i <= middle_number_ticket; i++) {
            left_summ += number[i];
            right_summ += number[1+middle_number_ticket+i];
        }

        return (left_summ == right_summ) ? true: false;
    }

    @Override
    public boolean isEvenLucky() {
        return this.isLucky() && (this.number[this.number.length-1]%2==0) ? true : false;
    }

    @Override
    public String toString() {
        return Arrays.toString(number);
    }
}
