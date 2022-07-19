package com.insignia.foundation;
import java.util.Scanner;

public class DigitsOfANum {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int num = sc.nextInt();
            int n = num;
            int count = 0;
            while (n != 0) {
                n = n / 10;
                count++;
            }
            int q = (int) Math.pow(10, count - 1);

            while (q != 0) {
                System.out.print(num / q+ " ");
                num=num % q;
                q = q / 10;
            }
        }
    }
}