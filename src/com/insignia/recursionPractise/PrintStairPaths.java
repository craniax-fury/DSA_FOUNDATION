package com.insignia.recursionPractise;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PrintStairPaths {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        printKpc(n,"");
    }

    public static void printKpc(int desOut,String out){
        if(desOut==0){
            System.out.println(out);
            return;
        }

        if(desOut<0){
            return;
        }

        for(int i=1;i<=3;i++){
            printKpc(desOut-i,out+i);
        }

    }
}