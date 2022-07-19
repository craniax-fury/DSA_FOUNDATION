package com.insignia.foundation;
import java.util.Scanner;
/**
 * we are not checking if the div itself is prime or not, 
 * because if a number is divisible by 6 then it will be catered in divisibility of 2 and 3, which are both prime
 */
public class PrimeFactorization {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int num = sc.nextInt();

            for(int div=2;div*div<=num;div++){
                while(num%div==0){
                    num=num/div;
                    System.out.print(div+" ");
                }
            }
            if(num!=1){
                System.out.print(num);
            }
            
        }
    }
}