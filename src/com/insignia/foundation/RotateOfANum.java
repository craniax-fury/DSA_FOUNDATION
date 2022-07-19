package com.insignia.foundation;
import java.util.Scanner;

public class RotateOfANum {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int num = sc.nextInt();
            int n=num;
            int rotations = sc.nextInt();
            
            int nod = numberOfDigits(n);

            int output = rotateNum(rotations, nod,num);

            System.out.println(output);

        }
    }

    private static int rotateNum(int rotations, int nod, int num) {
        if(rotations<0){
            rotations+=nod;
        }

        if(rotations==0){
            return num;
        }

        if(rotations>nod){
            rotations=rotations%nod;
        }

        int div = (int) Math.pow(10,rotations);
        int numToRotate = num%div;
        int remToAdd = num/div;
        int mulByPow = nod-rotations;
        return (int) Math.pow(10, mulByPow) * numToRotate + remToAdd;       
    }

    private static int numberOfDigits(int n) {
        int nod=0;
        
        while(n!=0){
            n=n/10;
            nod++;
        }
        return nod;
    }
}