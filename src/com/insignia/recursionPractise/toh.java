package com.insignia.recursionPractise;

import java.io.*;

public class toh {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int t1 = Integer.parseInt(br.readLine());
        int t2 = Integer.parseInt(br.readLine());
        int t3 = Integer.parseInt(br.readLine());

        toh(n,t1,t2,t3);

    }

    private static void toh(int n,int t1,int t2,int t3) {
        
        if(n==0){
            return;
        }

        toh(n-1,t1,t3,t2);
        System.out.println(n+"["+t1+"->"+t2+"]");
        toh(n-1,t3,t2,t1);
    }
}