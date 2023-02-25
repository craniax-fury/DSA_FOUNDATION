package com.insignia.searchingAndSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Formatter;

public class SquareRootUsingBinarySearch {

    public static int sqrt(int num) {

        int end = 0;

        if(num == 0 || num == 1){
            return num;
        }

        if(num<16){
            end = num;
        }else{
            end = num/4;
        }

        int start = 0;

        while(start<end){

            int mid = start + (end-start) / 2;
            
            //mid * mid == num is same as mid==num/mid
            if(mid == num/mid || ((mid+1) > num/(mid+1) && mid < num/mid)){
                return mid;
            
            }else if(mid > num/mid){
                end = mid;
            
            }else{
                start = mid+1;
            }
        }

        return start;
    }

    private static double sqrtPrecision(int num,int precision,int tempSol){

        double factor = 1;

        double ans = tempSol;

        for(int index = 0;index<precision;index++){
            factor = factor/10;

            for(double prec = ans; prec < num/prec; prec = prec+factor){
                ans = prec;
            }
        }

        return ans;

    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
    
            int output = sqrt(n);
            
            double ans = sqrtPrecision(n,3,output);
            
            System.out.println(new Formatter().format("%."+3+"f", ans));
        }
    }
}