package com.insignia.foundation;
import java.util.Scanner;
/**
 * on checking the iterations for few numbers,
 * it is evident that the bulbs which are on for odd number of times, will be on
 * bulbs i.e. 1,4,9,16..... are on,which hints us that the perfect squares have odd number of factors and so perfect squares only are
 * the bulbs are toggled for odd number of times hence the solution is to print the perfect squares.
 */
public class BenjaminBulbs {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int numOfBulbs = sc.nextInt();

            for(int i=1;i*i<numOfBulbs;i++){
                System.out.print(i*i+" ");
            }       
        }
    }
}