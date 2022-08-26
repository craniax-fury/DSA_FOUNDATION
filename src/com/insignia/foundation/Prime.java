package com.insignia.foundation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * run loop till sqrt of n
 * for any number n where p*q=n, p and q are its factor
 * either one of p or q <=sqrt n
 */
public class Prime{

    public static void main(String[] args) throws IOException{
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            int input = Integer.parseInt(reader.readLine());
            boolean isPrime = true;

            for(int idx=2;idx*idx<=input;idx++){
                if(input%idx==0){
                    isPrime = false;
                    break;
                }
            }

            System.out.println(isPrime);
        }

        
    }
}