package com.insignia.foundation;
import java.util.Scanner;
/**
 * input 36,24
 * 36%24
 * 24%12
 * output 12
 */
public class GCD {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            int div=1;
            int tempNum1 = num1;
            int tempNum2 = num2;
            while(div>0){
                div=tempNum1%tempNum2;
                tempNum1=tempNum2;
                tempNum2=div;
            }

            System.out.println(tempNum1);
        }
    }
}