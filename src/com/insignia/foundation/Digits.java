package com.insignia.foundation;
import java.util.Scanner;

public class Digits {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int count=0;
            while (n!=0) {
               n=n/10;
               count++;
            }
            System.out.println(count);
        }
    }
}