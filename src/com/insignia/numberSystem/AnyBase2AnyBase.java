package com.insignia.numberSystem;

import java.util.Scanner;
/**
 * convert number from any base to decimal, then convert number from decimal to the output base
 */
public class AnyBase2AnyBase {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int num = sc.nextInt();
            int from_base = sc.nextInt();
            int to_base = sc.nextInt();

            AnyBase2AnyBase anyBase2AnyBase = new AnyBase2AnyBase();
            System.out.println(anyBase2AnyBase.findNumberInBase(num, from_base, to_base));
        }
    }

    public int findNumberInBase(int num, int from_base, int to_base) {
        int result = 0;
        int place = 0;
       
        if(from_base==to_base){
            return num;
        }
        
        /**
         * convert number to decimal if from base is not decimal
        */

        if (from_base != 10 && from_base < 10) {
            int temp_num = num;

            while (temp_num != 0) {
                result += (temp_num % 10) *(int) Math.pow(from_base, place++);
                temp_num = temp_num / 10;
            }
            num=result;
            place=0;
            result=0;
        }
        
        if(to_base!=10 && to_base<10){     
            
            while(num!=0){
                result+=(num%to_base)* (int) Math.pow(10, place++);
                num=num/to_base;
            }
        }

        return result;
    }
}
