package com.insignia.recursion;

import java.io.*;

public class PrintDec {

    public static void main(String[] args) throws Exception {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            // int number = Integer.parseInt(reader.readLine());
            printDecreasing(3);
        }
    }

    public static void printDecreasing(int n){

        if(n==0){
            return;
        }

        System.out.println(n);
        printDecreasing(n-1);
    }

}