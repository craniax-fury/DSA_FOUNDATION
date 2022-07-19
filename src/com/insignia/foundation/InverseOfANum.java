package com.insignia.foundation;
import java.util.Scanner;

public class InverseOfANum {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int num = sc.nextInt();
            int inv = 0;
            int op = 1;
            while (num != 0) {
                int od = num % 10;
                num = num / 10;
                int ip = od;
                int id = op;
                op++;
                inv += id * (int) Math.pow(10, ip - 1);
            }

            System.out.println(inv);

        }
    }
}