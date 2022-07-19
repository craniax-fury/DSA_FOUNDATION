package com.insignia.foundation;
import java.util.Scanner;
/**
 * we are not checking if the div itself is prime or not, 
 * because if a number is divisible by 4 then it will be catered in divisibility of 2 and 3, which are both prime
 */
public class PythagoreanTriplets {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            int num3 = sc.nextInt();

            int max = num1;

            if(num2>max){
                max=num2;
            }

            if(num3>max){
                max=num3;
            }
            
            if(max==num1){
                checkPythagoreanTriplet(num2, num3, max);
            }

            if(max==num2){
                checkPythagoreanTriplet(num1, num3, max);
            }

            if(max==num3){
                checkPythagoreanTriplet(num2, num1, max);
            }
        }
    }

    private static void checkPythagoreanTriplet(int num2, int num3, int max) {
        System.out.println(max*max==num2*num2+num3*num3);
    }
}