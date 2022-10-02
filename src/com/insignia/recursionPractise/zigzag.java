package com.insignia.recursionPractise;

import java.io.*;

public class zigzag {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        zigzag(n);

    }

    private static void zigzag(int n) {
        if(n==1){
            System.out.print(1+" "+1+" "+1);
            return;
        }   

        System.out.print(" "+n+" ");
        zigzag(n-1); 
        System.out.print(" "+n+" ");
        zigzag(n-1);
        System.out.print(" "+n+" ");
    }

}