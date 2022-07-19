package com.insignia.arrays;

import java.util.Scanner;

public class DiffOfArrays {
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

            new_length = length_arr2;

            int[] result_arr = new int[new_length];

            int i = length_arr2 - 1;
            int j = length_arr1 - 1;
            int k = new_length - 1;

            while (i >= 0 || j >= 0) {
                int digit1 = 0;
                int digit2 = 0;

                if (i >= 0) {
                    digit1 = arr2[i];
                    if (carry != 0) {
                        digit1 += carry;
                    }
                }

                if (j >= 0) {
                    digit2 = arr1[j];
                }

                if (digit1 < digit2) {
                    carry = -1;
                    digit1 += 10;
                } else {
                    carry = 0;
                }

                int diff = digit1 - digit2;

                result_arr[k] = diff;

                k--;
                i--;
                j--;
            }

            for (int result : result_arr) {
                System.out.print(result);
            }
        }
    }
}
