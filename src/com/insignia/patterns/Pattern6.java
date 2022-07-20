package com.insignia.patterns;

import java.util.Scanner;

public class Pattern6 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
        //     int sp = 1;
        //     int st = n/2+1;
            
        // for (int i = 0; i < n; i++) {
        //         // System.out.print(sp + "," + st + " ");

        //         for (int k = 1; k <= st; k++) {
        //             System.out.print("*\t"+"  ");
        //         }

        //         for (int j = 1; j <= sp; j++) {
        //             System.out.print("\t");
        //         }

        //         for (int k = 1; k <= st; k++) {
        //             System.out.print("\t*");
        //         }

        //         if (i < n / 2) {
        //             sp+=2;
        //             st--;
        //         } else {
        //             sp-=2;
        //             st++;
        //         }
        //         System.out.println();
        //     }
        
        int sp=1;
        int st=n/2+1;

        for(int i=0;i<n;i++){
            for(int j=st;j>0;j--){
                System.out.print("*\t");
            }

            for(int k=1;k<=sp;k++){
                System.out.print("\t");
            }

            for(int j=st;j>0;j--){
                System.out.print("*\t");
            }

            if(i>=n/2){
                sp-=2;
                st++;
            }else{
                sp+=2;
                st--;
            }

            System.out.println();
        }
        }
    }
}
