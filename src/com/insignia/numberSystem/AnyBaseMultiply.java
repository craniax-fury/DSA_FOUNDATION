package com.insignia.numberSystem;

import java.util.Scanner;
/**
 * convert number from any base to decimal, then convert number from decimal to the output base
 */
public class AnyBaseMultiply {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            int base = sc.nextInt();

            AnyBaseMultiply anyBaseMultiply = new AnyBaseMultiply();
            System.out.println(anyBaseMultiply.findMultiplyInBase(num1, num2, base));
        }
    }

    public int findMultiplyInBase(int num1, int num2, int base) {

        AnyBaseMultiply anyBaseMultiply = new AnyBaseMultiply();        
        int sprd=0;
        int result=0;
        int place=0;

        while(num2!=0){
            int digit = num2%10;
            num2=num2/10;
            
            sprd = anyBaseMultiply.findMulBydigit(num1, digit, base);

            result = anyBaseMultiply.findAnyBaseAddition(result,sprd*(int) Math.pow(10, place++),base);
        }
        
        return result;
    }

    public int findMulBydigit(int num1,int digit,int base){
        int carry=0;
        int result=0;
        int place=0;

        while(num1!=0 || carry!=0){
            int temp_result=0;
            int dig1=num1%10;
            
            temp_result=dig1*digit+carry;
            
            carry = temp_result/base;
            result+=(temp_result%base)* (int) Math.pow(10, place++);
            
            num1=num1/10;
        }

        return result;
    }

    public int findAnyBaseAddition(int num1,int num2,int base){
        int res_q=0;
        int rem=0;
        int result=0;
        int place=0;

        while(num1!=0 || num2!=0 || res_q!=0){
            rem+=num1%10;
            rem+=num2%10;
            rem+=res_q;

            result+=(rem%base) * (int)Math.pow(10, place++);
            res_q= rem/base;

            num1=num1/10;
            num2=num2/10;

            rem=0;
        }

        return result;
    }

}
