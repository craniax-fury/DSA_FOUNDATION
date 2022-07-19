package com.insignia.numberSystem;

import java.util.Scanner;
/**
 * convert number from any base to decimal, then convert number from decimal to the output base
 */
public class AnyBaseAddition {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            int base = sc.nextInt();

            AnyBaseAddition anyBaseAddition = new AnyBaseAddition();
            System.out.println(anyBaseAddition.findAdditionInBase(num1, num2, base));
        }
    }

    public int findAdditionInBase(int num1, int num2, int base) {
        int res_q=0;

        int rem=0;
        int result=0;
        int place = 0;

        while(res_q!=0 || num1!=0 || num2!=0){
            rem+=num1%10;
            rem+=num2%10;
            rem+=res_q;

            res_q = rem/base;
            result += (rem%base)* (int) Math.pow(10,place++);
            
            num1=num1/10;
            num2=num2/10;

            rem=0;
        }
        return result;
    }

    // public int findAdditionInBase(int num1, int num2, int base) {

    //     AnyBase2Dec anyBase2Dec = new AnyBase2Dec();
        
    //     int num1InDec = anyBase2Dec.findNumberInDec(num1,base);
    //     int num2InDec = anyBase2Dec.findNumberInDec(num2,base);

    //     D2AnyBase d2AnyBase = new D2AnyBase();
    //     return d2AnyBase.findNumberInBase(num1InDec+num2InDec,base);
    // }
}
