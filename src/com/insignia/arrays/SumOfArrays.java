package com.insignia.arrays;

import java.util.Scanner;

public class SumOfArrays {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            int carry = 0;
            int new_length = 0;

            int length_arr1 = sc.nextInt();
            int[] arr1 = new int[length_arr1];

            for (int input = 0; input < length_arr1; input++) {
                arr1[input] = sc.nextInt();
            }

            int length_arr2 = sc.nextInt();
            int[] arr2 = new int[length_arr2];

            for (int input = 0; input < length_arr2; input++) {
                arr2[input] = sc.nextInt();
            }

            if (length_arr1 > length_arr2) {
                new_length = length_arr1;
            } else {
                new_length = length_arr2;
            }

            int[] result_arr = new int[new_length];

            int i = length_arr1 - 1;
            int j = length_arr2 - 1;
            int k = new_length - 1;

            while (i >= 0 || j >= 0) {
                int digit1 = 0;
                int digit2 = 0;

                if (i >= 0) {
                    digit1 = arr1[i];
                }

                if (j >= 0) {
                    digit2 = arr2[j];
                }

                int sum = digit1 + digit2 + carry;

                if (sum > 9) {
                    carry = sum / 10;
                    sum = sum % 10;
                } else {
                    carry = 0;
                }
                result_arr[k] = sum;

                k--;
                i--;
                j--;
            }

            if (carry != 0) {
                System.out.print(carry);
            }

            for (int result:result_arr) {
                System.out.print(result);
            }
        }
    }
}
