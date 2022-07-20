package com.insignia.patterns;

import java.util.Scanner;

public class Pattern2 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();

            // for (int i = n; i > 0; i--) {
            //     for (int j = i; j > 0; j--) {
            //         System.out.print("*" + " ");
            //     }
            //     System.out.println();
            // }

            int stars=n;

            for(int i=0;i<n;i++){
                for(int j=stars;j>0;j--){
                    System.out.print("*\t");
                }
                stars--;
                System.out.println();
            }
        }
    }
}
