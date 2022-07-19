package com.insignia.foundation;
import java.util.Scanner;

public class ReverseOfANum {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int num = sc.nextInt();
            int n = num;
            while (n != 0) {
                System.out.print(n % 10 + " ");
                n = n / 10;
            }
        }
    }
}