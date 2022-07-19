package com.insignia.patterns;

import java.util.Scanner;

public class Pattern9 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            method2(n);
        }
    }

    private static void method2(int n) {
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i+j==n+1 || i==j){
                    System.out.print("*\t");
                }else{
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }
}
