package com.insignia.foundation;
import java.util.Scanner;
/**
 * run loop till sqrt of n
 * for any number n where p*q=n, p and q are its factor
 * either one of p or q <=sqrt n
 */
public class Prime{
    public static void main(String[] args){
        try(Scanner sc = new Scanner(System.in)){
        int input = sc.nextInt();
        boolean isPrime=true;
        for(int i=2;i*i<=input;i++){
            if(input%i==0){
                isPrime=false;
                System.out.println("not prime");
                break;
            }
        }
        if(isPrime){
            System.out.println("prime");
        }
        }

        
    }
}