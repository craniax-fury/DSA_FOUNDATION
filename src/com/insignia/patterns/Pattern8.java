package com.insignia.patterns;

import java.util.Scanner;

public class Pattern8 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            method1(n);
            method2(n);
        }
    }

    private static void method2(int n) {
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i+j==n+1){
                    System.out.print("*");
                }else{
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }

    private static void method1(int n) {
        int sp = n-1;
        int st = 1;
        
      for (int i = 0; i < n; i++) {
            // System.out.print(sp + "," + st + " ");

            for (int j = 1; j <= sp; j++) {
                System.out.print("\t");
            }

            for (int k = 1; k <= st; k++) {
                System.out.print("*");
            }

            sp--;
            System.out.println();
        }
    }
}
