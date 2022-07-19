package com.insignia.numberSystem;

import java.util.Scanner;

/**
 * while substraction if the digit is less than the other digit then take carry
 * , 1 carry which is taken from the (place+1)th position becomes equal to the
 * base value
 */
public class AnyBaseSubstraction {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            int base = sc.nextInt();

            AnyBaseSubstraction anyBaseSubstraction = new AnyBaseSubstraction();
            System.out.println(anyBaseSubstraction.findSubstractionInBase(num1, num2, base));
        }
    }

    public int findSubstractionInBase(int num1, int num2, int base) {
        int result = 0;
        int place = 0;
        int carry = 0;

        int temp_num1 = 0;
        int temp_num2 = 0;

        while (num2 != 0) {
            temp_num1 = num1 % 10;
            temp_num2 = num2 % 10;

            temp_num2 += carry;

            if (temp_num2 < temp_num1) {
                temp_num2 += base;
                carry = -1;
            }

            result += (temp_num2 - temp_num1) * (int) Math.pow(10, place++);

            num1 = num1 / 10;
            num2 = num2 / 10;

        }
        return result;
    }
}
