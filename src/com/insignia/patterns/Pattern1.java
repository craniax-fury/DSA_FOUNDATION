package com.insignia.patterns;

import java.util.Scanner;

public class Pattern1 {
    public static void main(String[] args){
        try(Scanner sc = new Scanner(System.in)){
        int n = sc.nextInt();
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print("*"+" ");
            }
            System.out.println();
        }
    }
    }
}
