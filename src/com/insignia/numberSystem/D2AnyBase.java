package com.insignia.numberSystem;

import java.util.Scanner;

/**
 * for decimal to any base, keep dividing the number in decimal with the base you want to convert it in,
 * i.e. find the numbers in chunk of the resulting base
 * then atlast print the number in reverse order 
 */
public class D2AnyBase {
    
    public static void main(String[] args){
       try(Scanner sc = new Scanner(System.in)){
        int decNum =  sc.nextInt();
        int toBase = sc.nextInt();

        D2AnyBase d2AnyBase = new D2AnyBase();
        System.out.println(d2AnyBase.findNumberInBase(decNum,toBase));
       }
    }

    public int findNumberInBase(int decNum,int toBase){
        int rem = 1;
        int result=0;
        int place = 0;

        while(decNum>0){
            rem = decNum%toBase;
            decNum= decNum/toBase;
            result+=rem*(int)Math.pow(10, place++);
        }

        return result;
    }
}
